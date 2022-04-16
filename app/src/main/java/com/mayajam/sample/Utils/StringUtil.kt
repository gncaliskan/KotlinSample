package com.mayajam.sample.Utils

import android.text.Spanned
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import androidx.core.text.HtmlCompat

class StringUtil {
    fun isValidEmail(target: CharSequence?): Boolean {
        return if (!TextUtils.isEmpty(target)) Patterns.EMAIL_ADDRESS.matcher(target).matches() else false
    }

    fun fillHTML(html: String?): Spanned {
        val text = html ?: ""
        return HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_HEADING)
    }

    fun isEmpty(editText: EditText?): Boolean {
        return if(editText != null && editText.text !=null) editText.text.toString().isEmpty() else true
    }
}