package com.example.bilal.tempsms;

import java.util.Random;

/**
 * Created by Cate on 1/19/2016.
 */
public class SmsProcessor {

    String[] ShopList = {"Embroidery Palace \n" +
            "12 Commercial Zone Shop #12\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Zafar Iftikhar\n" +
            "0321-8882348\n",

            "Dressy Party Palace \n" +
            "12 Commercial Zone Shop #1\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Hussein Ahmed\t\t\t\n" +
            "0324-8882348\n" ,

            "Klassy Kurtas\n" +
            "12 Commercial Zone Shop #2\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Nabeel Gondal\n" +
            "0321-8823455\n" ,

            "Rizwan's Ready2ware \n" +
            "12 Commercial Zone Shop #3\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Rizwan Bajwa\n" +
            "0341-8833348\n" ,

            "Punjabi Pretties \n" +
            "12 Commercial Zone Shop #4\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Dawood Gil\n" +
            "0345-8813748\n" +
            "\",\"\n" +
            "Dress and Kurta and more\n" +
            "12 Commercial Zone Shop #5\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Saad Bhabra\n" +
            "0321-8882453\n",

            "Embroidery Excitement\n" +
            "12 Commercial Zone Shop #6\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Mohammad Derawal\n" +
            "0321-8853255\n",

            "Beauty Bazaar \n" +
            "12 Commercial Zone Shop #7\n" +
            "Ground Floor, Liberty Market, Gulberg 3\n" +
            "Shafqat Pitafi\n" +
            "0321-8920450\n",

            "Amazing Ali's \n" +
            "7 Commercial Zone Shop #13\n" +
            "Mini Mini Market\n" +
            "Ali Shambhani\n" +
            "0321-8394503\n",

            "Shalwaz Kabir's \n" +
            "7 Commercial Zone Shop #14\n" +
            "Mini Market\n" +
            "Kabir Talpur\n" +
            "0351-8284923\n",

            "Kurtas Kurtas Kurtas\n" +
            "7 Commercial Zone Shop #34\n" +
            "Mini Market\n" +
            "Qadir Sadozai\n" +
            "0321-9287410\n",

            "Beauty Shawls \n" +
            "7 Commercial Zone Shop #3\n" +
            "Mini Market\n" +
            "Omar Nizamani\n" +
            "0309-2948450\n" +
            "\",\"\n" +
            "Dupata Town \n" +
            "7 Commercial Zone Shop #15\n" +
            "Mini Market\n" +
            "Nasir Rahija\n" +
            "0324-1290242\n",

            "Dupata Shawls and More \n" +
            "7 Commercial Zone Shop #19\n" +
            "Mini Market\n" +
            "Obaid Sial\n" +
            "0333-1928490\n",

            "Embroidery Zone \n" +
            "7 Commercial Zone Shop #40\n" +
            "Mini Market\n" +
            "Hussain Khalol\n" +
            "0399-9290482\n",

            "Beauty Sometimes\n" +
            "12 Commercial Zone Shop #12\n" +
            "Mini Market\n" +
            "Raza Nothazai\n" +
            "0312-4958302"};
    //SQLiteDatabase db = ...

    public String receive(String number, String message){
        Random rand = new Random();
        int i = rand.nextInt(ShopList.length);

        String msg_header = "";

        return msg_header + ShopList[i];
    }
}
