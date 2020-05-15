package com.wkk.collection;

import java.util.*;

/**
 * @Time: 2020/5/14下午10:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        // 存储数据数据结构
        Map<String, List<Ticket>> map = new HashMap<>();
        // 存储结果数据结构
        Set<String> res = new HashSet<>();
        // 存储数据
        for (String transaction : transactions) {
            String[] split = transaction.split(",");
            Ticket ticket = new Ticket(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
            // 判断金钱
            if(ticket.money > 1000){
                res.add(transaction);
            }
            map.computeIfAbsent(ticket.name, k -> new ArrayList<>()).add(ticket);
        }
        for (Map.Entry<String, List<Ticket>> entry : map.entrySet()) {
            List<Ticket> tickets = entry.getValue();
            for (int i = 0; i < tickets.size()-1; i++) {
                for (int j = i+1; j < tickets.size(); j++) {
                    Ticket ticket1 = tickets.get(i);
                    Ticket ticket2 = tickets.get(j);
                    if(ticket1.region.equalsIgnoreCase(ticket2.region)){
                        continue;
                    }
                    // 判断时间
                    int diff = Math.abs(ticket1.time - ticket2.time);
                    if(diff<=60){
                        res.add(list2String(ticket1));
                        res.add(list2String(ticket2));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    private String list2String(Ticket ticket) {
        StringBuilder sb = new StringBuilder();
        sb.append(ticket.name).append(",");
        sb.append(ticket.time).append(",");
        sb.append(ticket.money).append(",");
        sb.append(ticket.region);
        return sb.toString();

    }

    class Ticket{
        String name;
        int time;
        int money;
        String region;

        public Ticket(String name, int time, int money, String region) {
            this.name = name;
            this.time = time;
            this.money = money;
            this.region = region;
        }
    }
}
