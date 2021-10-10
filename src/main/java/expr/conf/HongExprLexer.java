// Generated from E:/sources/antlr4-demo/src/main/java/expr\HongExprLexer.g4 by ANTLR 4.9.1
package expr.conf;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HongExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MUL=1, ADD=2, DIV=3, SUB=4, NEWLINE=5, WS=6, PARAM=7, NUMBER=8, KW_FRACTION=9, 
		KW_LBRACE=10, KW_RBRACE=11, KW_EQ=12, KW_LB=13, KW_RB=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MUL", "ADD", "DIV", "SUB", "NEWLINE", "WS", "PARAM", "ID", "NUMBER", 
			"DIGIT", "KW_FRACTION", "KW_LBRACE", "KW_RBRACE", "KW_EQ", "KW_LB", "KW_RB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'+'", null, "'-'", null, null, null, null, "'\\frac'", 
			"'{'", "'}'", "'='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MUL", "ADD", "DIV", "SUB", "NEWLINE", "WS", "PARAM", "NUMBER", 
			"KW_FRACTION", "KW_LBRACE", "KW_RBRACE", "KW_EQ", "KW_LB", "KW_RB"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HongExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HongExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\6\5\6\62\n\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\t\6\tB\n\t\r\t\16\tC\3"+
		"\n\5\nG\n\n\3\n\3\n\6\nK\n\n\r\n\16\nL\3\n\6\nP\n\n\r\n\16\nQ\3\n\3\n"+
		"\7\nV\n\n\f\n\16\nY\13\n\5\n[\n\n\5\n]\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\2\2\22\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\2\23\n\25\2\27\13\31\f\33\r\35\16\37\17!\20"+
		"\3\2\4\4\2\13\f\"\"\4\2C\\c|\2w\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\23\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3"+
		"#\3\2\2\2\5%\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\13\61\3\2\2\2\r\65\3\2\2\2"+
		"\179\3\2\2\2\21A\3\2\2\2\23F\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31f\3\2\2"+
		"\2\33h\3\2\2\2\35j\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#$\7,\2\2$\4\3\2\2\2%"+
		"&\7-\2\2&\6\3\2\2\2\'-\7\61\2\2()\7^\2\2)*\7f\2\2*+\7k\2\2+-\7x\2\2,\'"+
		"\3\2\2\2,(\3\2\2\2-\b\3\2\2\2./\7/\2\2/\n\3\2\2\2\60\62\7\17\2\2\61\60"+
		"\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\f\2\2\64\f\3\2\2\2\65\66"+
		"\t\2\2\2\66\67\3\2\2\2\678\b\7\2\28\16\3\2\2\29=\5\21\t\2:<\5\25\13\2"+
		";:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\20\3\2\2\2?=\3\2\2\2@B\t\3\2"+
		"\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\22\3\2\2\2EG\7/\2\2FE\3\2"+
		"\2\2FG\3\2\2\2G\\\3\2\2\2HJ\7\60\2\2IK\5\25\13\2JI\3\2\2\2KL\3\2\2\2L"+
		"J\3\2\2\2LM\3\2\2\2M]\3\2\2\2NP\5\25\13\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2"+
		"\2QR\3\2\2\2RZ\3\2\2\2SW\7\60\2\2TV\5\25\13\2UT\3\2\2\2VY\3\2\2\2WU\3"+
		"\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZS\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\H"+
		"\3\2\2\2\\O\3\2\2\2]\24\3\2\2\2^_\4\62;\2_\26\3\2\2\2`a\7^\2\2ab\7h\2"+
		"\2bc\7t\2\2cd\7c\2\2de\7e\2\2e\30\3\2\2\2fg\7}\2\2g\32\3\2\2\2hi\7\177"+
		"\2\2i\34\3\2\2\2jk\7?\2\2k\36\3\2\2\2lm\7*\2\2m \3\2\2\2no\7+\2\2o\"\3"+
		"\2\2\2\r\2,\61=CFLQWZ\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}