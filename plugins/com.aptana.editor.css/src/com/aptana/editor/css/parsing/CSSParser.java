package com.aptana.editor.css.parsing;

import java.util.ArrayList;
import java.util.List;
import com.aptana.parsing.ast.ParseError;
import com.aptana.parsing.ast.IParseRootNode;
import com.aptana.parsing.lexer.IRange;
import com.aptana.parsing.ast.ParseRootNode;
import com.aptana.editor.css.parsing.ast.*;
import beaver.*;
import com.aptana.parsing.IParser;
import com.aptana.parsing.IParseState;
import com.aptana.parsing.ast.IParseError;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "CSS.grammar".
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CSSParser extends Parser implements IParser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pDLcTuLKKGFVSLz4L41AIJn0WHyIL8IK82IKX8w7PGGQnO454K4O4a44X22pMK0A7t3h5" +
		"t53iMn8ueA601ks9NXhDxb$Zotir70lxWVj$PcPqxP#xipkvx0rY7C04JKOWfc8ofc8Rfc8" +
		"4YpCGiJC8S56Ckvc4#Ih002x48Ix0Kox0SYx42ix4IZR0Agx46Qx4Ewx416x49cqygufcE4" +
		"VEHXHh8HYvkGpGwem1DSJt6eIOyyA8QJiFfy24CPw0Uab0BBYIW4#eZ7Z58aU7mOoZQeJRk" +
		"Ho9YqH8NeHLQemtQ8WujTCHp655nEf9JXr7Ia8fqSYvWb53EUEPJr#JJZ9nRS3xEDfnabQq" +
		"KEsJRFYJR9Bso9iQNkTBNJrytkeNuAiyM8L7Tw17iAKUGWpin4FTW2#x67RWBWz0Gep0Qm$" +
		"00XcC4Hke8FT4L4QYE1hWClN4jpX8XCuhCBjm9cvc4JCtihcqnoC2vp53fvPZaNKvUSpGEu" +
		"aMMySuZxofS7SBhGru7X9Vn1cgUFOl1XLor7xUZRn1FrMeCQtK3#c4ihaD$rce0yXngfJop" +
		"w9cDMxbpAfjs68oBA#bvBovryCnXBGTY2EupUGwGsJhh79b5ktfiktgqdTB9hge0LY5O0fS" +
		"OnfM6SLCvlifDuGfSWrwqrYkptCZpUZCitW1to0cgpjjLWtjNasUr5cz37PxwkkJMvxusv5" +
		"rkp9COpdsEP8sZMA#cFDlHFDdDUGjE9gB7CM8CTzLdTjNFMHptE84xdiupq9ud8fct8PLtA" +
		"uryFyzVfiuXZ3DLWvwiayMPZ$FG739qH8iH5QS9VHJi7CAOGvW3fpFpiKm#Flh7SRs#ihnL" +
		"jf4EsKQ6PElNlfdbpakyzlM5#2hF38UeLeWdQFCpet3cQLUW3M##ge2zcoruKrI424OeNm7" +
		"5J2HJxOJDL7wAQTjKXbwzcwuWfiLeRfufRn0leXmldUiAvgK7yToQTopljbnrF5STohDh5Q" +
		"5hvUDv3gDdj4Ejb6SilUoTiy#5dz#hd6VN2ZmZzUzkkCapbfhAsg9q2n$RhZLjftIoSvUej" +
		"GoMHABDO3NiBoG6ydLk2bwENbez0POm0YZDrJy1ECYILbFwyS2d4z73wFs94gCFCdAi0wUv" +
		"pWfMb3stKeoiITGsUalZMspa4jhwgjyiytvmPV8B#cvXW3wRCV8fywiOOvkHUuazZ37Cv5D" +
		"e9FVHscNqtKOglrZ36qUzkx7t8$eOlIEnp#W7Z9n7h3Hw9h7zlpmi7v4LC6$0OOVvnX3ESu" +
		"szW9XOyNgidSTVirLQbJqw5S2d6L5q0ZprUnPH2RyrXFfdp3RprG7lZjN1xy3RJtImTQlH$" +
		"x1EEP5rbezX5PbOlGDiSumjpyZ30TyyKa4Sxfqrt$XiCfAzY9LXtaSH2G5njWRnsPDONOpU" +
		"gmhv3ws4Jv$AnZiLmAVK5lAl$2r$oP$oX$mklyclSbXRVz7ZpyHFn6FogCoJkORn8$63rbu" +
		"aNf27v44zAvKj73V9EbahawLG9ib4cI3ZPPmKIBxaoLWPOo8yBXjbfXJ939akSsI3h9VDKY" +
		"oFoCFc$JRYUQqzHspLshDwV4QFJ#lnAU99OesiakMoGfRAOiuMoK9PeD#Nw76#7dCaMx9af" +
		"8oG9R9CScMqZ9ALCascoXHvGbRBF$AzV2lVo24vA5$BL$AbV247PB$iay$bCzahU#HJ#KHs" +
		"oyUoIpwI3#K3UL$UatVb7TafRyiEUKlUb3VaTTakhychyegyB2$9T$pmUFPv5W7sKoxT0RO" +
		"x3fBu7zvUmyF#IS7BFib5MEoSJcqaC#zavfpCd9FP5QHmdi9vAcKgPKVAD0qFOR6Jyh0lTX" +
		"EgmrDm6RZPToXuT0VSINTZBiBIQ6kGG7i2PHpVnL6secobfUg3NOIbU#9OtKEvZEuclEpmB" +
		"0s$GJU3Z21q2K1y5T4w05qT47CKX2crGW==");

	private IParseState fParseState;

	// Collect the errors into a list of IParseErrors
	private class CSSEvents extends Events
	{
		public void scannerError(Scanner.Exception e)
		{
		}

		public void syntaxError(Symbol token)
		{
			if (token == null || fParseState == null)
			{
				return;
			}
			fParseState.addError(new ParseError(token, IParseError.ERROR));
		}

		public void unexpectedTokenRemoved(Symbol token)
		{
		}

		public void missingTokenInserted(Symbol token)
		{
		}

		public void misspelledTokenReplaced(Symbol token)
		{
		}

		public void errorPhraseRemoved(Symbol error)
		{
		}
	}

	public synchronized IParseRootNode parse(IParseState parseState) throws java.lang.Exception
	{
		fParseState = parseState;
		// grab source
		char[] characters = fParseState.getSource();

		// make sure we have some source
		String source = (characters != null) ? new String(characters) : ""; //$NON-NLS-1$

		fParseState.clearErrors();

		// create scanner and send source to it
		CSSScanner scanner = new CSSScanner();
		scanner.setSource(source);

		// parse
		ParseRootNode result = (ParseRootNode) parse(scanner);
		int start = fParseState.getStartingOffset();
		int end = start + fParseState.getSource().length - 1;
		result.setLocation(start, end);

		// store results in the parse state
		fParseState.setParseResult(result);

		// attach comments to parse root node
		IRange[] comments = scanner.getComments();
		CSSCommentNode[] commentNodes = new CSSCommentNode[comments.length];

		for (int i = 0; i < comments.length; i++)
		{
			IRange comment = comments[i];
			CSSCommentNode commentNode = new CSSCommentNode( //
					this.getSource(fParseState, comment), comment.getStartingOffset(), comment.getEndingOffset());

			commentNodes[i] = commentNode;
		}

		result.setCommentNodes(commentNodes);
		fParseState = null;

		return result;
	}

	private String getSource(IParseState parseState, IRange comment)
	{
		char[] src = parseState.getSource();
		int length = comment.getLength();
		char[] dest = new char[length];

		System.arraycopy(src, comment.getStartingOffset(), dest, 0, length);

		return new String(dest);
	}

	public CSSParser() {
		super(PARSING_TABLES);


		report = new CSSEvents();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // Program = Statements.p
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final ArrayList _list_p = (ArrayList) _symbol_p.value;
					final CSSNode[] p = _list_p == null ? new CSSNode[0] : (CSSNode[]) _list_p.toArray(new CSSNode[_list_p.size()]);
					
			return new CSSParseRootNode(p);
			}
			case 1: // Program = 
			{
					
			return new CSSParseRootNode();
			}
			case 2: // Statements = Statements Statement
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
			}
			case 3: // Statements = Statement
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
			}
			case 12: // CharSet = CHARSET STRING.s SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					
			return new CSSCharSetNode(s);
			}
			case 13: // Import = IMPORT ImportWord.s SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					
			return new CSSImportNode(s);
			}
			case 14: // Import = IMPORT ImportWord.s List.w SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					final Symbol _symbol_w = _symbols[offset + 3];
					final List<CSSTextNode> w = (List<CSSTextNode>) _symbol_w.value;
					
			return new CSSImportNode(s, w.toArray(new CSSTextNode[w.size()]));
			}
			case 15: // Media = MEDIA_KEYWORD MediaExprs.m LCURLY RCURLY
			{
					final Symbol _symbol_m = _symbols[offset + 2];
					final ArrayList _list_m = (ArrayList) _symbol_m.value;
					final beaver.Symbol[] m = _list_m == null ? new beaver.Symbol[0] : (beaver.Symbol[]) _list_m.toArray(new beaver.Symbol[_list_m.size()]);
					
			List<CSSTextNode> list = new ArrayList<CSSTextNode>();

			for (Symbol symbol : m)
			{
				CSSTextNode text = new CSSTextNode((String) symbol.value);

				text.setLocation(symbol.getStart(), symbol.getEnd());
				list.add(text);
			}

			return new CSSMediaNode(list.toArray(new CSSTextNode[list.size()]));
			}
			case 16: // Media = MEDIA_KEYWORD MediaExprs.m LCURLY Statements.s RCURLY
			{
					final Symbol _symbol_m = _symbols[offset + 2];
					final ArrayList _list_m = (ArrayList) _symbol_m.value;
					final beaver.Symbol[] m = _list_m == null ? new beaver.Symbol[0] : (beaver.Symbol[]) _list_m.toArray(new beaver.Symbol[_list_m.size()]);
					final Symbol _symbol_s = _symbols[offset + 4];
					final ArrayList _list_s = (ArrayList) _symbol_s.value;
					final CSSNode[] s = _list_s == null ? new CSSNode[0] : (CSSNode[]) _list_s.toArray(new CSSNode[_list_s.size()]);
					
			List<CSSTextNode> list = new ArrayList<CSSTextNode>();

			for (Symbol symbol : m)
			{
				CSSTextNode text = new CSSTextNode((String) symbol.value);

				text.setLocation(symbol.getStart(), symbol.getEnd());
				list.add(text);
			}

			return new CSSMediaNode(list.toArray(new CSSTextNode[list.size()]), s);
			}
			case 17: // MediaExprs = MediaExprs MediaExpr
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 18: // MediaExprs = MediaExpr
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 59: // Page = PAGE LCURLY RCURLY
			{
					
			return new CSSPageNode();
			}
			case 60: // Page = PAGE LCURLY Declarations.d RCURLY
			{
					final Symbol _symbol_d = _symbols[offset + 3];
					final List<CSSDeclarationNode> d = (List<CSSDeclarationNode>) _symbol_d.value;
					
			return new CSSPageNode(d);
			}
			case 61: // Page = PAGE COLON IDENTIFIER.s LCURLY RCURLY
			{
					final Symbol _symbol_s = _symbols[offset + 3];
					final String s = (String) _symbol_s.value;
					
			CSSPageSelectorNode pageSelector = new CSSPageSelectorNode(s);
			CSSPageNode result = new CSSPageNode();

			pageSelector.setLocation(_symbol_s.getStart(), _symbol_s.getEnd());
			result.setSelector(pageSelector);

			return result;
			}
			case 62: // Page = PAGE COLON IDENTIFIER.s LCURLY Declarations.d RCURLY
			{
					final Symbol _symbol_s = _symbols[offset + 3];
					final String s = (String) _symbol_s.value;
					final Symbol _symbol_d = _symbols[offset + 5];
					final List<CSSDeclarationNode> d = (List<CSSDeclarationNode>) _symbol_d.value;
					
			CSSPageSelectorNode pageSelector = new CSSPageSelectorNode(s);
			CSSPageNode result = new CSSPageNode(d);

			pageSelector.setLocation(_symbol_s.getStart(), _symbol_s.getEnd());
			result.setSelector(pageSelector);

			return result;
			}
			case 63: // FontFace = FONTFACE LCURLY RCURLY
			{
					
			return new CSSFontFaceNode();
			}
			case 64: // FontFace = FONTFACE LCURLY Declarations.d RCURLY
			{
					final Symbol _symbol_d = _symbols[offset + 3];
					final List<CSSDeclarationNode> d = (List<CSSDeclarationNode>) _symbol_d.value;
					
			return new CSSFontFaceNode(d);
			}
			case 65: // Namespace = NAMESPACE ImportWord.w SEMICOLON
			{
					final Symbol _symbol_w = _symbols[offset + 2];
					final String w = (String) _symbol_w.value;
					
			return new CSSNamespaceNode(w);
			}
			case 66: // Namespace = NAMESPACE IDENTIFIER.i ImportWord.w SEMICOLON
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_w = _symbols[offset + 3];
					final String w = (String) _symbol_w.value;
					
			return new CSSNamespaceNode(i, w);
			}
			case 67: // AtRule = AT_RULE.a STRING.s SEMICOLON
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					
			return new CSSAtRuleNode(a, s);
			}
			case 68: // Rule = Selectors.s LCURLY RCURLY
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final List<CSSSelectorNode> s = (List<CSSSelectorNode>) _symbol_s.value;
					
			CSSRuleNode result = new CSSRuleNode(s);

			for (CSSSelectorNode selector : s)
			{
				selector.setParent(result);
			}

			return result;
			}
			case 69: // Rule = Selectors.s LCURLY Declarations.d RCURLY
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final List<CSSSelectorNode> s = (List<CSSSelectorNode>) _symbol_s.value;
					final Symbol _symbol_d = _symbols[offset + 3];
					final List<CSSDeclarationNode> d = (List<CSSDeclarationNode>) _symbol_d.value;
					
			CSSRuleNode result = new CSSRuleNode(s, d);

			for (CSSSelectorNode selector : s)
			{
				selector.setParent(result);
			}

			CSSSelectorNode firstSelector = s.get(0);

			for (CSSDeclarationNode declaration : d)
			{
				declaration.setParent(firstSelector);
			}

			return result;
			}
			case 71: // Function = Identifier.i LPAREN Expression.e RPAREN
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final CSSExpressionNode e = (CSSExpressionNode) _symbol_e.value;
					
			return new CSSFunctionNode(i, e);
			}
			case 72: // List = List COMMA IDENTIFIER.i
			{
					final Symbol _symbol_i = _symbols[offset + 3];
					final String i = (String) _symbol_i.value;
					
		List<CSSTextNode> list = (List<CSSTextNode>) _symbols[offset + 1].value;
		CSSTextNode text = new CSSTextNode(i);

		text.setLocation(_symbol_i.getStart(), _symbol_i.getEnd());
		list.add(text);

		return _symbols[offset + 1];
			}
			case 73: // List = IDENTIFIER.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					
		List<CSSTextNode> list = new ArrayList<CSSTextNode>();
		CSSTextNode text = new CSSTextNode(i);

		text.setLocation(_symbol_i.getStart(), _symbol_i.getEnd());
		list.add(text);

		return new Symbol(list);
			}
			case 74: // Declarations = Declaration.d
			{
					final Symbol _symbol_d = _symbols[offset + 1];
					final CSSDeclarationNode d = (CSSDeclarationNode) _symbol_d.value;
					
			List<CSSDeclarationNode> list = new ArrayList<CSSDeclarationNode>();

			list.add(d);

			return new Symbol(list);
			}
			case 75: // Declarations = Declaration.d SEMICOLON.s
			{
					final Symbol _symbol_d = _symbols[offset + 1];
					final CSSDeclarationNode d = (CSSDeclarationNode) _symbol_d.value;
					final Symbol s = _symbols[offset + 2];
					
			List<CSSDeclarationNode> list = new ArrayList<CSSDeclarationNode>();

			d.setHasSemicolon(s);
			list.add(d);

			return new Symbol(list);
			}
			case 76: // Declarations = Declarations.ds Declaration.d
			{
					final Symbol _symbol_ds = _symbols[offset + 1];
					final List<CSSDeclarationNode> ds = (List<CSSDeclarationNode>) _symbol_ds.value;
					final Symbol _symbol_d = _symbols[offset + 2];
					final CSSDeclarationNode d = (CSSDeclarationNode) _symbol_d.value;
					
			ds.add(d);

			return _symbols[offset + 1];
			}
			case 77: // Declarations = Declarations.ds Declaration.d SEMICOLON.s
			{
					final Symbol _symbol_ds = _symbols[offset + 1];
					final List<CSSDeclarationNode> ds = (List<CSSDeclarationNode>) _symbol_ds.value;
					final Symbol _symbol_d = _symbols[offset + 2];
					final CSSDeclarationNode d = (CSSDeclarationNode) _symbol_d.value;
					final Symbol s = _symbols[offset + 3];
					
			d.setHasSemicolon(s);
			ds.add(d);

			return _symbols[offset + 1];
			}
			case 78: // Declaration = Identifier.i COLON Expression.e
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final CSSExpressionNode e = (CSSExpressionNode) _symbol_e.value;
					
			return new CSSDeclarationNode(i, e);
			}
			case 79: // Declaration = Identifier.i COLON Expression.e IMPORTANT.s
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final CSSExpressionNode e = (CSSExpressionNode) _symbol_e.value;
					final Symbol s = _symbols[offset + 4];
					
			return new CSSDeclarationNode(i, e, s);
			}
			case 80: // Declaration = error
			{
					
			return new CSSErrorDeclarationNode();
			}
			case 81: // Expression = Expression.e Separator.s Term.t
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final CSSExpressionNode e = (CSSExpressionNode) _symbol_e.value;
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final CSSExpressionNode t = (CSSExpressionNode) _symbol_t.value;
					
			return new CSSTermListNode(e, t, s);
			}
			case 82: // Expression = Expression.e Term.t
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final CSSExpressionNode e = (CSSExpressionNode) _symbol_e.value;
					final Symbol _symbol_t = _symbols[offset + 2];
					final CSSExpressionNode t = (CSSExpressionNode) _symbol_t.value;
					
			return new CSSTermListNode(e, t);
			}
			case 84: // Expression = error
			{
					
			return new CSSErrorExpressionNode();
			}
			case 85: // Term = Primitive.p
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final String p = (String) _symbol_p.value;
					
			return new CSSTermNode(p);
			}
			case 87: // Selectors = Selectors.ss Combinator.c Selector.s
			{
					final Symbol _symbol_ss = _symbols[offset + 1];
					final List<CSSSelectorNode> ss = (List<CSSSelectorNode>) _symbol_ss.value;
					final Symbol _symbol_c = _symbols[offset + 2];
					final String c = (String) _symbol_c.value;
					final Symbol _symbol_s = _symbols[offset + 3];
					final CSSSelectorNode s = (CSSSelectorNode) _symbol_s.value;
					
			CSSSelectorNode lastSelector = ss.get(ss.size() - 1);
			lastSelector.setCombinator(c);

			ss.add(s);

			return _symbols[offset + 1];
			}
			case 88: // Selectors = Selector.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final CSSSelectorNode s = (CSSSelectorNode) _symbol_s.value;
					
			List<CSSSelectorNode> list = new ArrayList<CSSSelectorNode>();

			list.add(s);

			return new Symbol(list);
			}
			case 89: // Selector = Selector.s SimpleSelector.ss
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final CSSSelectorNode s = (CSSSelectorNode) _symbol_s.value;
					final Symbol _symbol_ss = _symbols[offset + 2];
					final CSSSimpleSelectorNode ss = (CSSSimpleSelectorNode) _symbol_ss.value;
					
			s.addChild(ss);

			return s;
			}
			case 90: // Selector = SimpleSelector.ss
			{
					final Symbol _symbol_ss = _symbols[offset + 1];
					final CSSSimpleSelectorNode ss = (CSSSimpleSelectorNode) _symbol_ss.value;
					
			CSSSelectorNode selector = new CSSSelectorNode();

			selector.addChild(ss);

			return selector;
			}
			case 91: // SimpleSelector = TypeOrUniversalSelector.t AttributeSelectors.a
			{
					final Symbol _symbol_t = _symbols[offset + 1];
					final String t = (String) _symbol_t.value;
					final Symbol _symbol_a = _symbols[offset + 2];
					final ArrayList _list_a = (ArrayList) _symbol_a.value;
					final CSSAttributeSelectorNode[] a = _list_a == null ? new CSSAttributeSelectorNode[0] : (CSSAttributeSelectorNode[]) _list_a.toArray(new CSSAttributeSelectorNode[_list_a.size()]);
					
			return new CSSSimpleSelectorNode(t, a);
			}
			case 92: // SimpleSelector = TypeOrUniversalSelector.t
			{
					final Symbol _symbol_t = _symbols[offset + 1];
					final String t = (String) _symbol_t.value;
					
			return new CSSSimpleSelectorNode(t);
			}
			case 93: // SimpleSelector = AttributeSelectors.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final ArrayList _list_a = (ArrayList) _symbol_a.value;
					final CSSAttributeSelectorNode[] a = _list_a == null ? new CSSAttributeSelectorNode[0] : (CSSAttributeSelectorNode[]) _list_a.toArray(new CSSAttributeSelectorNode[_list_a.size()]);
					
			return new CSSSimpleSelectorNode(a);
			}
			case 94: // AttributeSelectors = AttributeSelectors AttributeSelector
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
			}
			case 95: // AttributeSelectors = AttributeSelector
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
			}
			case 96: // AttributeSelector = CLASS.c
			{
					final Symbol _symbol_c = _symbols[offset + 1];
					final String c = (String) _symbol_c.value;
					
			return new CSSAttributeSelectorNode(c);
			}
			case 97: // AttributeSelector = COLON.c Identifier.i
			{
					final Symbol _symbol_c = _symbols[offset + 1];
					final String c = (String) _symbol_c.value;
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					
			return new CSSAttributeSelectorNode(c + i);
			}
			case 98: // AttributeSelector = COLON Function.f
			{
					final Symbol _symbol_f = _symbols[offset + 2];
					final CSSExpressionNode f = (CSSExpressionNode) _symbol_f.value;
					
			return new CSSAttributeSelectorNode(f);
			}
			case 99: // AttributeSelector = HASH.h
			{
					final Symbol _symbol_h = _symbols[offset + 1];
					final String h = (String) _symbol_h.value;
					
			return new CSSAttributeSelectorNode(h);
			}
			case 100: // AttributeSelector = LBRACKET.l Identifier.i RBRACKET.r
			{
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_r = _symbols[offset + 3];
					final String r = (String) _symbol_r.value;
					
			return new CSSAttributeSelectorNode(l + i + r);
			}
			case 101: // AttributeSelector = LBRACKET.l Identifier.i AttributeValueOperator.o IdentiferOrString.s RBRACKET.r
			{
					final Symbol _symbol_l = _symbols[offset + 1];
					final String l = (String) _symbol_l.value;
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_o = _symbols[offset + 3];
					final String o = (String) _symbol_o.value;
					final Symbol _symbol_s = _symbols[offset + 4];
					final String s = (String) _symbol_s.value;
					final Symbol _symbol_r = _symbols[offset + 5];
					final String r = (String) _symbol_r.value;
					
			return new CSSAttributeSelectorNode(l + i + " " + o + " " + s + r);
			}
			case 4: // Statement = CharSet
			case 5: // Statement = Import
			case 6: // Statement = Media
			case 7: // Statement = Page
			case 8: // Statement = FontFace
			case 9: // Statement = Namespace
			case 10: // Statement = AtRule
			case 11: // Statement = Rule
			case 19: // MediaExpr = IDENTIFIER
			case 20: // MediaExpr = PROPERTY
			case 21: // MediaExpr = COLOR
			case 22: // MediaExpr = COLON
			case 23: // MediaExpr = RCURLY
			case 24: // MediaExpr = STRING
			case 25: // MediaExpr = LBRACKET
			case 26: // MediaExpr = CLASS
			case 27: // MediaExpr = HASH
			case 28: // MediaExpr = SEMICOLON
			case 29: // MediaExpr = URL
			case 30: // MediaExpr = STAR
			case 31: // MediaExpr = SELECTOR
			case 32: // MediaExpr = COMMA
			case 33: // MediaExpr = NUMBER
			case 34: // MediaExpr = PERCENTAGE
			case 35: // MediaExpr = LENGTH
			case 36: // MediaExpr = EMS
			case 37: // MediaExpr = EXS
			case 38: // MediaExpr = ANGLE
			case 39: // MediaExpr = TIME
			case 40: // MediaExpr = FREQUENCY
			case 41: // MediaExpr = PAGE
			case 42: // MediaExpr = AT_RULE
			case 43: // MediaExpr = CHARSET
			case 44: // MediaExpr = MEDIA_KEYWORD
			case 45: // MediaExpr = FONTFACE
			case 46: // MediaExpr = NAMESPACE
			case 47: // MediaExpr = IMPORT
			case 48: // MediaExpr = RBRACKET
			case 49: // MediaExpr = LPAREN
			case 50: // MediaExpr = PLUS
			case 51: // MediaExpr = SLASH
			case 52: // MediaExpr = MINUS
			case 53: // MediaExpr = RPAREN
			case 54: // MediaExpr = IMPORTANT
			case 55: // MediaExpr = GREATER
			case 56: // MediaExpr = EQUAL
			case 57: // MediaExpr = INCLUDES
			case 58: // MediaExpr = DASHMATCH
			case 70: // Rule = error
			case 83: // Expression = Term
			case 86: // Term = Function
			case 102: // ImportWord = STRING
			case 103: // ImportWord = URL
			case 104: // Identifier = IDENTIFIER
			case 105: // Identifier = PROPERTY
			case 106: // IdentiferOrString = IDENTIFIER
			case 107: // IdentiferOrString = STRING
			case 108: // Separator = SLASH
			case 109: // Separator = COMMA
			case 110: // Separator = PLUS
			case 111: // Separator = MINUS
			case 112: // Combinator = COMMA
			case 113: // Combinator = PLUS
			case 114: // Combinator = GREATER
			case 115: // Primitive = NUMBER
			case 116: // Primitive = PERCENTAGE
			case 117: // Primitive = LENGTH
			case 118: // Primitive = EMS
			case 119: // Primitive = EXS
			case 120: // Primitive = ANGLE
			case 121: // Primitive = TIME
			case 122: // Primitive = FREQUENCY
			case 123: // Primitive = STRING
			case 124: // Primitive = IDENTIFIER
			case 125: // Primitive = URL
			case 126: // Primitive = COLOR
			case 127: // TypeOrUniversalSelector = IDENTIFIER
			case 128: // TypeOrUniversalSelector = STAR
			case 129: // TypeOrUniversalSelector = SELECTOR
			case 130: // AttributeValueOperator = EQUAL
			case 131: // AttributeValueOperator = INCLUDES
			case 132: // AttributeValueOperator = DASHMATCH
			case 133: // AttributeValueOperator = BEGINS_WITH
			case 134: // AttributeValueOperator = ENDS_WITH
			{
				return _symbols[offset + 1];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}
