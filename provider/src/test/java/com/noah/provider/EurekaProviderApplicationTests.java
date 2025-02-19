package com.noah.provider;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest
class EurekaProviderApplicationTests {

    public static void main2(String[] args) {
        Random random = new Random();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int i = 1; i <= 100000000; i++) {
            one.add(random.nextInt(35));
            two.add(random.nextInt(12));
        }
        Map<Integer, Long> collectOne = one.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> collectTwo = two.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> integerLongMapOne = sortByValue(collectOne);
        Map<Integer, Long> integerLongMapTwo = sortByValue(collectTwo);
        integerLongMapOne.remove(0);
        integerLongMapTwo.remove(0);
        Set<Integer> integers = integerLongMapOne.keySet();
        Set<Integer> integers1 = integerLongMapTwo.keySet();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            Integer randomElement = getRandomElement(integers);
            integers.remove(randomElement);
            Integer randomElement2 = getRandomElement(integers);
            integers.remove(randomElement2);
            Integer randomElement3 = getRandomElement(integers);
            integers.remove(randomElement3);
            Integer randomElement4 = getRandomElement(integers);
            integers.remove(randomElement4);
            Integer randomElement5 = getRandomElement(integers);
            integers.remove(randomElement5);
            Integer randomElement6 = getRandomElement(integers1);
            integers.remove(randomElement6);
            Integer randomElement7 = getRandomElement(integers1);
            integers.remove(randomElement7);
            sb.append(randomElement).append("-").append(randomElement2).append("-").append(randomElement3).append("-").append(randomElement4).append("-").append(randomElement5).append(" ").append(randomElement6).append("-").append(randomElement7).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static Map<Integer, Long> sortByValue(Map<Integer, Long> map) {
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Integer, Long> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Long> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static Integer getRandomElement(Set<Integer> set) {
// 将Set转换为数组
        Integer[] array = set.toArray(new Integer[0]);
// 生成随机索引
        Random rand = new Random();
        int randomIndex = rand.nextInt(array.length);
// 返回随机选择的元素
        return array[randomIndex];
    }

    public static Boolean matchRegularExpression(String pattern, String dateStr) {
        if (StringUtils.isEmpty(pattern) || StringUtils.isEmpty(dateStr)) {
            return false;
        }
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dateStr);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList("".split(",")));
    }


}
