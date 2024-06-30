package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

//    チャットGPTでランダムな8文字の文字列を30個生成
    List<String> randomStrings = Arrays.asList(
        "漢2㍍Qw8掘り",
        "狂k1ōタゴV3eú4",
        "M0ヤdàā3モのg",
        "的G5mュザしæKぬ",
        "ご1行ŝñō1YÅ7",
        "ヨ6ヮD漢9Vォ3",
        "À行7の工ジ達",
        "チャZōア9仏き",
        "8ヤ1ū2ヤャýi",
        "3にア6yォɾō",
        "2㍍Qw8掘りe矛",
        "1ōタゴV3eú4毎",
        "0ヤdàā3モのg",
        "G5mュザしæKぬゾ",
        "1行ŝñō1YÅ7毎",
        "6ヮD漢9Vォ3甘",
        "行7の工ジ達サ",
        "Zōア9仏き漢演",
        "ヤ1ū2ヤャýiē",
        "にア6yォɾō行",
        "1Qw8掘りe矛7",
        "ōタゴV3eú4毎ビ",
        "ヤdàā3モのg阿",
        "mュザしæKぬゾ0",
        "行ŝñō1YÅ7毎的",
        "ヮD漢9Vォ3甘y",
        "7の工ジ達サ8",
        "A9仏き漢演習b",
        "ヤ1ū2ヤャýiēで"
    );

    Pattern numberPattern = Pattern.compile("\\d+");
    Pattern englishPattern = Pattern.compile("[a-zA-Z]+");
    Pattern uppercasePattern = Pattern.compile("[A-Z]+");
    Pattern japanesePattern = Pattern.compile("[\\p{IsHiragana}\\p{IsKatakana}\\p{IsHan}]+");
    Pattern otherEnglishPattern = Pattern.compile("[^\\p{Alnum}]+");

//    数字だけを抜き出す正規表現
    List<List<String>> numberList = randomStrings.stream()
        .map(v -> numberPattern.matcher(v).results()
            .map(MatchResult::group)
            .collect(Collectors.toList()))
        .toList();
    System.out.println("数字だけ抜き出し\n" + numberList);

//    英字だけを抜き出す正規表現
    List<List<String>> stringList = randomStrings.stream()
        .map(v -> englishPattern.matcher(v).results()
            .map(MatchResult::group)
            .collect(Collectors.toList()))
        .toList();
    System.out.println("英字だけ抜き出し\n" + stringList);

    //    英数字の大文字だけを抜き出す正規表現
    List<List<String>> uppercaseList = randomStrings.stream()
        .map(v -> uppercasePattern.matcher(v).results()
            .map(MatchResult::group)
            .collect(Collectors.toList()))
        .toList();
    System.out.println("英数字の大文字だけ抜き出し\n" + uppercaseList);

    //    日本語だけを抜き出す正規表現
    List<List<String>> japaneseList = randomStrings.stream()
        .map(v -> japanesePattern.matcher(v).results()
            .map(MatchResult::group)
            .collect(Collectors.toList()))
        .toList();
    System.out.println("日本語だけ抜き出し\n" + japaneseList);

    //    英数字以外を抜き出す正規表現
    List<List<String>> otherEngilishList = randomStrings.stream()
        .map(v -> otherEnglishPattern.matcher(v).results()
            .map(MatchResult::group)
            .collect(Collectors.toList()))
        .toList();
    System.out.println("英数字以外を抜き出し\n" + otherEngilishList);
  }
}
