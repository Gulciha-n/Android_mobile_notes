package com.example.datatransport

import java.io.Serializable

class People (var tcNo : Int , var name :String, var age : Int) :Serializable {



}

/*

Serileştirme, bir objedeki verileri bir akışa (dosya, ağ bağlantısı vb.) yazarak veya bu akıştan okuyarak 
aktarılabilir bir formata dönüştürme işlemidir. Serileştirme işlemi sayesinde nesnelerin durumu, verileri ve yapıları korunarak 
başka bir yerde kullanılabilir veya saklanabilir hale gelir.
Java'da serileştirme, bir nesnenin Serializable interface'ini uygulayarak gerçekleştirilir.

*/
