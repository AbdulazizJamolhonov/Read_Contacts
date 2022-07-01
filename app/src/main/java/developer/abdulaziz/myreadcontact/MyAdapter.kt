package developer.abdulaziz.myreadcontact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulaziz.myreadcontact.databinding.ItemBinding

class MyAdapter(
    private var list: ArrayList<Contact>
) :
    RecyclerView.Adapter<MyAdapter.ViewHolderUser>() {

    inner class ViewHolderUser(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(contact: Contact) {
            binding.apply {
                txtName.text = contact.name
                txtPhone.text = contact.phone
                if (contact.image != null) {
                    image.setImageBitmap(contact.image)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser =
        ViewHolderUser(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(hol: ViewHolderUser, pos: Int) = hol.onBind(list[pos])
    override fun getItemCount(): Int = list.size
}