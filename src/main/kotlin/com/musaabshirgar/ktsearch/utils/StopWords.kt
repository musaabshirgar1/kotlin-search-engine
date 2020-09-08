package com.musaabshirgar.ktsearch.utils

import java.util.*

class StopWords {
    private val h: Hashtable<String, Boolean?> = Hashtable()

    fun isStopWord(s: String): Boolean {
        var ret = h[s] != null
        if (s.length == 1) ret = true
        return ret
    }
    companion object {
        var instance: StopWords? = null
            get() {
                if (field == null) field = StopWords()
                return field
            }
            private set
    }
    init {
        h["0"] = true
        h["1"] = true
        h["2"] = true
        h["3"] = true
        h["4"] = true
        h["5"] = true
        h["6"] = true
        h["7"] = true
        h["8"] = true
        h["9"] = true
        h["a"] = true
        h["about"] = true
        h["above"] = true
        h["after"] = true
        h["again"] = true
        h["against"] = true
        h["all"] = true
        h["am"] = true
        h["an"] = true
        h["and"] = true
        h["any"] = true
        h["are"] = true
        h["aren't"] = true
        h["as"] = true
        h["at"] = true
        h["be"] = true
        h["because"] = true
        h["been"] = true
        h["before"] = true
        h["being"] = true
        h["below"] = true
        h["between"] = true
        h["both"] = true
        h["but"] = true
        h["by"] = true
        h["can't"] = true
        h["cannot"] = true
        h["could"] = true
        h["couldn't"] = true
        h["did"] = true
        h["didn't"] = true
        h["do"] = true
        h["does"] = true
        h["doesn't"] = true
        h["doing"] = true
        h["don't"] = true
        h["down"] = true
        h["during"] = true
        h["each"] = true
        h["few"] = true
        h["for"] = true
        h["from"] = true
        h["further"] = true
        h["had"] = true
        h["hadn't"] = true
        h["has"] = true
        h["hasn't"] = true
        h["have"] = true
        h["haven't"] = true
        h["having"] = true
        h["he"] = true
        h["he'd"] = true
        h["he'll"] = true
        h["he's"] = true
        h["her"] = true
        h["here"] = true
        h["here's"] = true
        h["hers"] = true
        h["herself"] = true
        h["him"] = true
        h["himself"] = true
        h["his"] = true
        h["how"] = true
        h["how's"] = true
        h["i"] = true
        h["i'd"] = true
        h["i'll"] = true
        h["i'm"] = true
        h["i've"] = true
        h["if"] = true
        h["in"] = true
        h["into"] = true
        h["is"] = true
        h["isn't"] = true
        h["it"] = true
        h["it's"] = true
        h["its"] = true
        h["itself"] = true
        h["let's"] = true
        h["me"] = true
        h["more"] = true
        h["most"] = true
        h["mustn't"] = true
        h["my"] = true
        h["myself"] = true
        h["no"] = true
        h["nor"] = true
        h["not"] = true
        h["of"] = true
        h["off"] = true
        h["on"] = true
        h["once"] = true
        h["only"] = true
        h["or"] = true
        h["other"] = true
        h["ought"] = true
        h["our"] = true
        h["ours "] = true
        h[" ourselves"] = true
        h["out"] = true
        h["over"] = true
        h["own"] = true
        h["same"] = true
        h["shan't"] = true
        h["she"] = true
        h["she'd"] = true
        h["she'll"] = true
        h["she's"] = true
        h["should"] = true
        h["shouldn't"] = true
        h["so"] = true
        h["some"] = true
        h["say"] = true
        h["said"] = true
        h["such"] = true
        h["than"] = true
        h["that"] = true
        h["that's"] = true
        h["the"] = true
        h["their"] = true
        h["theirs"] = true
        h["them"] = true
        h["themselves"] = true
        h["then"] = true
        h["there"] = true
        h["there's"] = true
        h["these"] = true
        h["they"] = true
        h["they'd"] = true
        h["they'll"] = true
        h["they're"] = true
        h["they've"] = true
        h["this"] = true
        h["those"] = true
        h["through"] = true
        h["to"] = true
        h["too"] = true
        h["under"] = true
        h["until"] = true
        h["up"] = true
        h["very"] = true
        h["was"] = true
        h["wasn't"] = true
        h["we"] = true
        h["we'd"] = true
        h["we'll"] = true
        h["we're"] = true
        h["we've"] = true
        h["were"] = true
        h["weren't"] = true
        h["what"] = true
        h["what's"] = true
        h["when"] = true
        h["when's"] = true
        h["where"] = true
        h["where's"] = true
        h["which"] = true
        h["while"] = true
        h["who"] = true
        h["who's"] = true
        h["whom"] = true
        h["why"] = true
        h["why's"] = true
        h["with"] = true
        h["won't"] = true
        h["would"] = true
        h["wouldn't"] = true
        h["you"] = true
        h["you'd"] = true
        h["you'll"] = true
        h["you're"] = true
        h["you've"] = true
        h["your"] = true
        h["yours"] = true
        h["yourself"] = true
        h["yourselves "] = true
    }
}