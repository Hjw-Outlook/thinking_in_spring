package org.hjw.ioc.java.normaltest;

import java.text.ParseException;

/**
 * @ClassName RundeTest
 * @Description TODO
 * @Author H_jw
 * @Date 2022-07-01 0001 下午 02:41
 * @Version 1.0
 */
public class RundeTest {

    public static void main(String[] args) throws ParseException {

        //List<Integer> aList = new ArrayList<>();
        //aList.add(1);
        //aList.add(2);
        //aList.add(3);
        //Set<Integer> aSet = new HashSet<>();
        //Map<Integer, List<Integer>> userGroupTkSubjectIdsMap = new HashMap<>();
        //userGroupTkSubjectIdsMap.put(1,aList);
        //aSet.addAll(userGroupTkSubjectIdsMap.get(1));
        //List<Integer> bList = new ArrayList<>(aSet);
        //System.out.println(bList);


//        List<Integer> bList = new ArrayList<>();
//        bList.add(2);
//        bList.add(4);
//        System.out.println(aList.stream().filter(bList::contains).collect(Collectors.toList()));


//        Integer orderInt = 305200;
//        System.out.println(
//                new BigDecimal(orderInt).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
//        Date now = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startTime = dateFormat.parse("2022-09-01 00:00:00");
//        System.out.println(now.before(startTime));
//        Date endTime = dateFormat.parse("2022-09-05 00:00:00");
//        System.out.println(now.after(endTime));
//        System.out.println(startTime.getTime() > endTime.getTime());
//        List<String> userSubjectModelList = new ArrayList<>();
//        userSubjectModelList.add("1");
//        userSubjectModelList.add("2");
//        System.out.println(userSubjectModelList.stream().anyMatch("3"::equals));

//        System.out.println(new Date().compareTo(startTime));

//        System.out.println(secondToDate(10, "hh:mm:ss"));
//        System.out.println(getDate(36110));

        String a = "AB";
        System.out.println(a.toCharArray());
    }


//    /**
//     * 秒转换为指定格式的日期
//     *
//     * @param second
//     * @param patten
//     * @return
//     */
//    private static String secondToDate(long second, String patten) {
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(second * 1000);//转换为毫秒
//        Date date = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat(patten);
//        String dateString = format.format(date);
//        return dateString;
//    }

    private static String getDate(Integer seconds) {
        int h = seconds / 3600;
        String hour = formatSecondsStr(h);
        int m = (seconds % 3600) / 60;
        String min = formatSecondsStr(m);
        int s = (seconds % 3600) % 60;
        String sec = formatSecondsStr(s);
        return hour + ":" + min + ":" + sec;
    }

    private static String formatSecondsStr(int date) {
        if (date < 10) {
            return "0" + date;
        }
        return "" + date;
    }

}
