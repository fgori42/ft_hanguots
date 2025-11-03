package fgori.ft_hanguots

class Message {

    var direction: MsgDir
    var content: String

    constructor(InOrOut: MsgDir, content: String) {
        this.direction = InOrOut;
        this.content = content;
    }
}
