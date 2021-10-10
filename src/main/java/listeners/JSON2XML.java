package listeners;

import listeners.json.JSONBaseListener;
import listeners.json.JSONLexer;
import listeners.json.JSONParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description     :
 */
public class JSON2XML {
	public static class XMLEmitter extends JSONBaseListener {
        ParseTreeProperty<String> xml = new ParseTreeProperty<String>();
        String getXML(ParseTree ctx) { return xml.get(ctx); }
        void setXML(ParseTree ctx, String s) { xml.put(ctx, s); }

        public void exitJson(JSONParser.JsonContext ctx) {
            setXML(ctx, getXML(ctx.getChild(0)));
        }

        public void exitAnObject(JSONParser.AnObjectContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("\n");
            for (JSONParser.PairContext pctx : ctx.pair()) {
                buf.append(getXML(pctx));
            }
            setXML(ctx, buf.toString());
        }
        public void exitEmptyObject(JSONParser.EmptyObjectContext ctx) {
            setXML(ctx, "");
        }

        public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("\n");
            for (JSONParser.ValueContext vctx : ctx.value()) {
                buf.append("<element>"); // conjure up element for valid XML
                buf.append(getXML(vctx));
                buf.append("</element>");
                buf.append("\n");
            }
            setXML(ctx, buf.toString());
        }

        public void exitEmptyArray(JSONParser.EmptyArrayContext ctx) {
            setXML(ctx, "");
        }

        public void exitPair(JSONParser.PairContext ctx) {
            String tag = stripQuotes(ctx.STRING().getText());
            JSONParser.ValueContext vctx = ctx.value();
            String x = String.format("<%s>%s</%s>\n", tag, getXML(vctx), tag);
            setXML(ctx, x);
        }

        public void exitObjectValue(JSONParser.ObjectValueContext ctx) {
            // analogous to String value() {return object();}
            setXML(ctx, getXML(ctx.object()));
        }

        public void exitArrayValue(JSONParser.ArrayValueContext ctx) {
            setXML(ctx, getXML(ctx.array())); // String value() {return array();}
        }

        public void exitAtom(JSONParser.AtomContext ctx) {
            setXML(ctx, ctx.getText());
        }

        public void exitString(JSONParser.StringContext ctx) {
            setXML(ctx, stripQuotes(ctx.getText()));
        }

        public static String stripQuotes(String s) {
            if ( s==null || s.charAt(0)!='"' ) return s;
            return s.substring(1, s.length() - 1);
        }
    }

    @SuppressWarnings("all")
	public static void main(String[] args) throws IOException {
		InputStream is = JSON2XML.class.getClassLoader().getResourceAsStream("listeners/t.json");
		ANTLRInputStream input = new ANTLRInputStream(is);
		JSONLexer lexer = new JSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JSONParser parser = new JSONParser(tokens);

		ParseTree tree = parser.json();
		ParseTreeWalker walker = new ParseTreeWalker();
		XMLEmitter converter = new XMLEmitter();
		walker.walk(converter, tree);
		System.out.println(converter.getXML(tree));
	}
}
