package com.hllbr.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*

    AlertDialog ?

    Projelerde kullanıcıya bazı mesajlar göstermek istediğim durumlarda (hata mesajları yol gösterici vb...) devreye giren bir sistem(bir ileşitim yoönlendirme) aracı

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Toast Test",Toast.LENGTH_LONG).show();
    }
    public void testButonOpened(View view){
        //Bu aladna kullanıcıya alarm dialog ile uyarı mesajı göstermeye açlışacağım ...

        AlertDialog.Builder alertTest = new AlertDialog.Builder(this);

                //alertDialog.Builder = bir uyarı mesajı inşa et oalrak ifade edebilirim

                //alertDialog.Builder = komple bir sınıf adı olarak düşünmek daha mantıklı olacaktır yapının mantığı normal sınıflardan biraz farklı

                //AlertDialog contructor/parametre alanı için bir Context = bir bağlam / kaynak isteyecek.Bu isteğin sebebi nereden oluşturayım ? oalrak tercüme edilebilir.

                //şimdi uyarı mesajının başlığını belirlemem gerekiyor bunun için setTitle kullanıyorum
        alertTest.setTitle("Save ??");


        //Dialog içersinde vereceğim mesaj için ise ...

        alertTest.setMessage("Are You Sure !!!");

        //şimdi ise iki adet buton ile kullanıcıdan direktif almam gerekiyor işlemi onaylamalı yada vazgeçmeli

        //bu işlem için hazır oluşturulmuş metodlar bulunmakta bunlaradn faydalanacağım


        alertTest.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                /*Yes butonuna tıklandığında olacak olayların yazıldığı alan

                Toast message == küçük popup mesaj olarak ifade edilen bir yapı kullanmak istiyorum bu alanda

                toast mesaj oluştururkken build değil make (yap) metodu ile birlikte kullanıyoruz make içerisinde parametre olarak bizden bir context isteniyor nerede yapayım olarak ifade edebiliriz.

                ikinci parametre olarak  ne mesajı verileceğini yazıyorum duration soruyor süre olarak çevirebilirim

                sharedpreferences için apply() uygula demiştim.Toast için ise show() kullanıyoruz göster olarak ifade edilebilir.

                Toast mesajı onCreate içersindede başka alanardada istediğim her yerde her zaman dilimi yada her işlem esnasında kullanıcıya gösterebilirim.

                 */

                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
            }
        });

        //birinci parametrede buton üzerinde yazmak istediğim isim ikinci parametre ise bir listener yazmama gerekiyor.

        //burada listener birşeye tıklandığında veya olay meydana geldiğinde ne olacağını yazdığım dinleyici metodlar (arayüzler) olarak ifade edeilebilir.

        //genellikle üzerinde yazdığımız listenerlar bulunuyor android bu konuda hazır listenerler açısından zengin bir yapıya sahiptir.

        //bu aladna negative buton için aynı işlemleri gerçekleştiriyorum.

        alertTest.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"NOT SAVED",Toast.LENGTH_LONG).show();

            }
        });

        alertTest.show();//bu kullanılmadığında alert dialog gösterilmeyecektir.Kritik bir nokta ...


    }



    /*
    Context nedir ??

    Android projesi içerisinde ne oluyor kim kiminle iletişime geçiyor .Arkaplanda nasıl işlemler dönüyor.Hepsinin tutulduğu br durum gibi düşünülebiir.

    Context kendi içinde 2 ye ayrılıyor gibi düşünülmeli

    1)Activity Context

    2)App Context

    1)Activity context activiteyi ilgilendiren contexttir.Şuana kadar text activity ile çalışmalar yaptım fakat bunu yapamk zorunda değiliz ve projeden projeye göre activity sayısı değişkenlik gösterebilir.

    MainActivity içersinde yapıalacak işlemler ile MainActivity2 içerisinde yapmak istediğim işelemler farklılık gösterebilir.2 activitenin contexti farklı olabilir.

    activitelerden biri kapandığında o alandaki context direkt olarak kapanabilir.gibi gibi...

    activity contexte ulaşamak için this veya MainActivity.this kullanıyoruz.Bunlar aynı anlama geliyorlar.

    Bazı durumlarda ise uygulamanın(app) geneliyle ilgili contexte ulaşmak gerekiyor.

    App context'e ulaşmak için ise getApplicationContext bir metoddan faydalanıyoruz.

    Ne zaman getApplicationContext ne zaman this/MainActivity.this kullanılır ??

    activite ile ilgili durumlarda this

    appi ilgilendiren durumlarda ise getApplicationContext kullanıyoruz.

    Basitleştirecek olursak activite ile ilgili durumlar daha özel daha spesifik uygulamayla ilgili durumlar ise daha genel global istekler olarka ifade edeilebilir.

    Çoğunlukla getApplicationContext kullanmak işimize yarar ...

    genel app ile ilgili şeyler activiteyle ilgilide olur çoğunlukla !!!

    Bu yapı sadece toast yada alert dialog ile karşımıza çıkmadığı için documents üzerinden kullanımlarına bakabiliriz...

    Toastmesajı yes/no butonu içerisinde this olarak ifade edersem onClickListener içersinde olduğu için onu referans olarak alır ve hata verir.

    Bu hatayı düzeltmek için sadece this yazmak yerine getApplicationContext yada MainActivity.this yazmak gerekir...

    Oncreate içerisinde this yazdığımızda ise bu sorun olmaz çünkü onCreate mainActivity için referans veriyor.



     */
}