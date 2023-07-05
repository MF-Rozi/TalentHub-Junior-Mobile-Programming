fun main(){
    checkPalindrom("Apa")
    checkPalindrom("Katak")
    checkPalindrom("ApaH")
}
fun checkPalindrom(text: String){
    var lowercased = text.lowercase()
    var reversed = lowercased.reversed()
    if (lowercased == reversed){
        println("Text: $text is Palindrom")
    }else{
        println("Text: $text is not Palindrom")
    }
}
