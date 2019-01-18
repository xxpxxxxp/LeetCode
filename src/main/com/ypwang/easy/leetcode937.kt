package com.ypwang.easy

class Solution937 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
            logs.sortWith(Comparator {
                a, b ->
                val split1 = a.split(" ")
                val split2 = b.split(" ")
                val isDigit1 = split1[1].first().isDigit()
                val isDigit2 = split2[1].first().isDigit()
                if (!isDigit1 && !isDigit2) {
                    val cmp = split1[1].compareTo(split2[1])
                    if (cmp != 0) cmp else split1[0].compareTo(split2[0])
                } else {
                    if (isDigit1) if (isDigit2) 0 else 1 else -1
                }
            })
        return logs
    }
}

fun main(args: Array<String>) {
    println(Solution937().reorderLogFiles(
            arrayOf("xo5azp0sy438 eppzlhfig b zqbplfyajpldf gumdyp mren",
                    "y urbltdl inymvoxqnmorxjvqnukhjzjuqbmfzgaofugpekkq",
                    "euh0v9 iqwpxxwzbitgrdkgtcxskyntvuv sjwgqve m cvuix",
                    "j1ui6j njcdloocdcxny yzaxmacbvoetwqpxkmtfqadfgsae",
                    "m 202223205741076969483509798 7160145522681 570 64",
                    "749h5b4cab fpgwucwpctbwlvowgdszbpyqhstvc tzasw w z",
                    "mr5rclq8feck 994267474958090434699137392 43 48608",
                    "nvw8h 24414920926497850 18325167688 76698444 57794",
                    "bcm02q 543508522367504502 48671385291989464 9 3 0",
                    "9h7vsrqksk 2 0967650 34081 8210 8931451282986104 0",
                    "4vo6 qmdnnzfivnjfanji qhccqahduutvdqwkyq m hpr gk",
                    "5alhm zbuspxitqtgzsjiypwbqlwiwbqhwibyiuyoidsxcxv i",
                    "uwlkv 73507775173 48055333280884883652535401813 38",
                    "uj21sgy 2797073586772431417991244392 7878655 6974",
                    "egmaz5ffky0 mkeqs kbkovftoiyxxvtophoysdqyh dogup x",
                    "9uwopk8k0tc juaidntdeeewc senqksyhwr jvketdvl jt j",
                    "omm9mi fpgnguo mgodblqbpkw rdjvhekkjwgieov jsrncqb",
                    "3mb26jz k qngtl kmlyzwwyvrlyqn witcavitdhspxrzqvd",
                    "md taccyrevrgaquvgfozwavyzgufgdkpeijxzlnqnkwlr nlu",
                    "36i20b8f 37239 38908131553695937 1085395906 82 1 9",
                    "lacy9wy 451350628010 4 48196669862790199 8 05 977",
                    "e 61547159797346550043910287594745232 482800842 1",
                    "ozg 29902091 54341226227873351364631 655190857 106",
                    "tdzjqjhw58h5 2531459555779785286249831504205 6640",
                    "oi twufnncaalytfropfnyhwexuo rqqmxshnsccflgkdlt d",
                    "cry1x mbpvikvfzryoobeylffwttnvs qwxpbvwjzjrzab o r",
                    "59rkvid 3311023924290358450280425 604822 802770 1",
                    "7zgopd 9676160956507709532877050609 188916504243 9",
                    "hk51xtrth8p 224592643693773305 3191 251614208269 9",
                    "audsw9p8h 02823235611738688913057224444 96 3 07843",
                    "db xhmzhpfkvefzubdfkziachykzqoidvsgiex vvlngzey v",
                    "hwf6o2 93729900182041951815591228 838499129 23 54",
                    "co vpygskbfdnznkoulsvlabcxcsvimlmxmyi dujj a a x s",
                    "2ukf jdyumvstawzxmzkzbjweznzdy rkear lscmmtaqcobrr",
                    "b84le2 1334 282915784617314752513870 837981637 76",
                    "2ei tiddvvkevljvdtbzaponhulqxypywsdljkpzhaoeaefg x",
                    "zpj953 06883903397 50448735380966 57369 7890967679",
                    "olxgfaq5tj8 34256370456025093806696 73 5 287125 6",
                    "tzh shzwhwrmktpycgyjapzcgn faxbqgpowj bavhtxqtfbux",
                    "8ys25m 372892 56 3244265047887 0782561363271811 3",
                    "dnxnv7wo81c 038228717290 65441839545345402798416 9",
                    "1 tizhimqlfwjcheioswnetsknzojgdcmmxxcozbbeenewjcxr",
                    "u3vshrhhs4xe 4133177266905066378889447658717940159",
                    "v 9799144076967953001550730 12294059 628636 3051 6",
                    "4jenwm stnzsfqdituynspzflqoulylnxzaucguz y mtxlnko",
                    "b8x0 napzvhpmhgqh oczavwzoxwjjoboq hvgqeb pcxvw oj",
                    "yw3p mnvbgjaffwkszlcsjxgtlswpojaqubhgbtvnndysvwppk",
                    "w7491a5qp3g fxv bgvlhvaydisustmnwmbvyftwwzeh apzgp",
                    "b44gyws iqminvwqyqduksboszxaapmtefzhq ihcxhnhqztce",
                    "aesf 07837121 931304647882778878289052163339 9 8 4")))
}