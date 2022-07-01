package developer.abdulaziz.myreadcontact

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import developer.abdulaziz.myreadcontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactList: ArrayList<Contact>

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            contactList = ArrayList()
            btn.setOnClickListener {
                val contacts = contentResolver.query(
                    CONTENT_URI,
                    null,
                    null,
                    null
                )
                while (contacts!!.moveToNext()) {
                    val contact = Contact(
                        contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    )
                    val rasmUrl =
                        contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))

                    if (rasmUrl != null) {
                        contact.image =
                            MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(rasmUrl))
                    }

                    contactList.add(contact)
                }
                contacts.close()

                rv.adapter = MyAdapter(contactList)
            }
        }
    }
}