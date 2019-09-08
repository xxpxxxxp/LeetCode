package com.ypwang.medium

class Solution1181 {
    data class WordTree(val c: Char, var isWord: Boolean, val follow: Array<WordTree?>, var idx: MutableList<Int>? = null)

    /** Initialize your data structure here. */
    private val root = WordTree('0', false, Array(26){ null })

    /** Adds a word into the data structure. */
    private fun addWord(word: String, idx: Int) {
        var r = root
        for ((index, c) in word.withIndex()) {
            val i = c.toInt() - 'a'.toInt()
            if (r.follow[i] == null) {
                r.follow[i] = WordTree(c, false, Array(26) { null })
            }
            r = r.follow[i]!!
            if (index == word.lastIndex) {
                r.isWord = true
                if (r.idx == null) r.idx = mutableListOf()
                r.idx!!.add(idx)
            }
        }
    }

    private fun findWord(word: String): WordTree? {
        var r = root
        for (c in word) {
            val i = c.toInt() - 'a'.toInt()
            if (r.follow[i] == null) return null
            r = r.follow[i]!!
        }

        return r
    }

    fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
        for ((i, phrase) in phrases.withIndex()) {
            val pos = phrase.indexOf(' ')
            val word = if (pos == -1) phrase else phrase.substring(0, pos)
            addWord(word, i)
        }

        val rst = mutableSetOf<String>()
        for ((i, phrase) in phrases.withIndex()) {
            val pos = phrase.indexOfLast { it == ' ' }
            val word = if (pos == -1) phrase else phrase.substring(pos+1)
            val node = findWord(word)
            if (node != null && node.isWord) {
                for (j in node.idx!!) {
                    if (i != j) {
                        val t = phrase + phrases[j].substring(word.length)
                        if (rst.isEmpty() || t != rst.last()) rst.add(t)
                    }
                }
            }
        }

        return rst.toList().sorted()
    }
}

fun main() {
    Solution1181().beforeAndAfterPuzzles(arrayOf("ghanuo qxi b vxbjg stdsoe xylid e jss skzkhfy f dihh id","vxbjg","wy uia bbg ulfoyo wmss e uia qznglzi kuoqsjm jjarip sdfrvleh agq qznglzi dihh skfm","wmss b chyfiw z chyfiw uvq qjrfodti pgjuaolq id aee ncbd cjmnmexu zclfup gwgeyw qxi aee id skzkhfy","wmss uia xylid bbg jjarip agq chyfiw skzkhfy uhmc aee ddicv e sdfrvleh nq","jss wj f agq uhmc pkore vxbjg ghanuo ddicv","qjrfodti e jss uhmc agq qznglzi nq id nq z aee vnckr skzkhfy pgjuaolq zclfup ulfoyo","pgjuaolq rwlxefgf gwgeyw kuoqsjm wj wmss b e","e aekq wmss agq uhmc vlyp wj qxi jss uhmc uvq ncbd vn wj agq","skfm jjarip wy agq pxqqtzw vn skfm z yoskkg zclfup e qjrfodti vlyp jjarip wj e b","sdfrvleh qznglzi uhmc id aee qznglzi z agq stdsoe","kuoqsjm cfjo skzkhfy rwlxefgf aekq chyfiw sdfrvleh nq e zclfup vlyp","qxi","agq kuoqsjm z skfm z jjarip aekq qznglzi skfm jss pxqqtzw ddicv skzkhfy e cfjo skzkhfy wy e","vxbjg qxi jjarip vn","id z jjarip jjarip yoskkg ncbd uia uia cjmnmexu","rwlxefgf cfjo pxqqtzw f chyfiw ddicv gwgeyw qxi vlyp jjarip pkore uvq f skzkhfy","wy uhmc vxbjg agq ghanuo zclfup z aee","bbg uia rwlxefgf skfm z z","z uvq zclfup wj agq stdsoe vnckr vlyp jjarip z ncbd b vnckr vlyp dihh f dihh vlyp agq pxqqtzw f","aekq z qznglzi chyfiw uia aee zclfup zclfup stdsoe z aee gwgeyw uhmc uyotjsgg thifuxm f","qznglzi cjmnmexu wy pkore vnckr wj wj wj","xylid z wmss e cfjo ulfoyo wy vn bbg ncbd yoskkg ghanuo b qznglzi ncbd xylid","gwgeyw pxqqtzw vnckr dihh sdfrvleh f z","e jjarip aekq bbg aekq wj z ghanuo pkore pgjuaolq","vn chyfiw uhmc id uvq","f vnckr z rwlxefgf f skzkhfy ncbd qznglzi thifuxm qjrfodti stdsoe uyotjsgg z id","kuoqsjm qznglzi wj yoskkg cjmnmexu gwgeyw gwgeyw thifuxm","gwgeyw f e ncbd aee xylid ddicv vlyp yoskkg ulfoyo z yoskkg chyfiw b qxi qjrfodti bbg","z vnckr sdfrvleh aekq uyotjsgg e vxbjg wy ulfoyo aekq skzkhfy wj f rwlxefgf pxqqtzw","e jjarip vnckr skfm rwlxefgf qjrfodti sdfrvleh aee wmss f","aee qznglzi qjrfodti uyotjsgg e z b vn uia cfjo ghanuo f thifuxm cjmnmexu aee z uhmc thifuxm pkore","wy uhmc sdfrvleh aekq zclfup kuoqsjm kuoqsjm z aee","qjrfodti z jss skzkhfy wj wy","bbg pgjuaolq zclfup wy","vxbjg vn wy","z e pxqqtzw vnckr pxqqtzw pkore b wmss gwgeyw uia ghanuo z cjmnmexu wj wj chyfiw jss","thifuxm vn kuoqsjm z vnckr wj yoskkg ncbd uvq kuoqsjm skzkhfy jss yoskkg chyfiw vlyp skfm dihh wy b","uvq uia qjrfodti cjmnmexu dihh vlyp jjarip qznglzi wmss wj","uvq z vn vn stdsoe uyotjsgg qxi z","uhmc aee stdsoe","f cfjo ddicv bbg skfm kuoqsjm qjrfodti e","chyfiw id f uhmc ddicv e qxi zclfup z vn e","id pkore e dihh uhmc stdsoe wj vn","aee skzkhfy jjarip uyotjsgg z aekq e wj pkore uvq wy dihh jss f","wy qznglzi pkore qjrfodti vlyp agq qxi","cjmnmexu dihh sdfrvleh stdsoe vnckr vxbjg uvq cjmnmexu uhmc agq xylid b","e z cjmnmexu uhmc qxi ddicv jss cjmnmexu vnckr e jjarip jjarip aekq ncbd e dihh","wmss vn qznglzi id skfm ncbd aee ghanuo zclfup wj pxqqtzw ulfoyo id","rwlxefgf stdsoe cjmnmexu f qxi ghanuo e uvq agq thifuxm stdsoe jss ulfoyo vlyp b ddicv e z")).forEach { println(it) }
//    println(Solution1181().beforeAndAfterPuzzles(arrayOf("mission statement",
//            "a quick bite to eat",
//            "a chip off the old block",
//            "chocolate bar",
//            "mission impossible",
//            "a man on a mission",
//            "block party",
//            "eat my words",
//            "bar of soap")))
//    println(Solution1181().beforeAndAfterPuzzles(arrayOf("a","b","a")))
}