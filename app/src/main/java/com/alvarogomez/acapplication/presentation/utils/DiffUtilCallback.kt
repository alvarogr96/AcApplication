package com.alvarogomez.acapplication.presentation.utils

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val areItemsTheSameCallback: (T, T) -> Boolean,
    private val areContentsTheSameCallback: (T, T) -> Boolean
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return areItemsTheSameCallback(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areContentsTheSameCallback(oldList[oldItemPosition], newList[newItemPosition])
    }
}