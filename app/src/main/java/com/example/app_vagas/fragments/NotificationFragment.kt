package com.example.app_vagas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment

class NotificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_notification, container, false)
    }

    // aqui você pode usar o findViewById normalmente e acessar os elementos da interface do usuário
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // exemplo de uso do findViewById, toda lógica deve ser feita aqui
        val myRadioButton = view.findViewById<RadioButton>(R.id.ID_Notification_AtiveNotification)
    }
}