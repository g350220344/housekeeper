package com.cindata.housekeeper.core.common.tools;

import com.vdurmont.emoji.EmojiParser;

public class EmojiUtil {
	private static EmojiParser emojiParser = null;


	public static void main(String[] args) {
	    String str = "&#10024;多多&#10024;";
        //String str = "Are U ok?&#127764;";
	    str = strParseToEmoji(str);
	    System.out.println(str);
	}
	/**
	 * @Describe 将emoji 表情 转HtmlDecimal
	 * @Author  gaoy
	 * @Time  2018/07/13 02:15:51
	 * @param
	 **/
	public static String strParseToHtmlDecimal(String str) {
		if(emojiParser == null){
			emojiParser = new EmojiParser();
		}
		return emojiParser.parseToHtmlDecimal(str);
	}

	/**
	 * @Describe 将HtmlDecimal 转emoji 表情
	 * @Author  gaoy
	 * @Time  2018/07/13 02:15:51
	 * @param
	 **/
	public static String strParseToEmoji(String str) {
		if(emojiParser == null){
			emojiParser = new EmojiParser();
		}
		return emojiParser.parseToUnicode(str);
	}
}