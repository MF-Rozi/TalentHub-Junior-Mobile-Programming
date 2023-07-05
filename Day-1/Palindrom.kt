fun main(){
    print("Tulis Kata Palindrom: ")
    var kata = readln();
    checkPalindrom(kata)
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
