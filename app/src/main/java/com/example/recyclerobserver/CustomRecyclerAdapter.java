package com.example.recyclerobserver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Observable;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    RecyclerClickListener listener;
    ArrayList<ScannableCode> localDataset;

    CustomRecyclerAdapter(RecyclerClickListener listener) {
        this.listener = listener;
        UserDataModel model = UserDataModel.getInstance();
        localDataset = model.getLocalData();
    }

    // Create View Holder and inflate view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_content, parent, false);
        return new ViewHolder(view);    }

    // Bind data to view holder

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getCodeName().setText(localDataset.get(position).getCodeName());
        holder.getCodeScore().setText(localDataset.get(position).getCodeScore());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.onItemClick(holder.itemView, holder.getAbsoluteAdapterPosition());
            else
                throw new IllegalStateException("Click listener not set");
        });
    }

    // Return number of items in Adapter
    @Override
    public int getItemCount() {
        if (localDataset != null) {
            return localDataset.size();
        } else {
            return 0;
        }
    }

    public void updateData(Observable o) {
        UserDataModel model = (UserDataModel) o;
        localDataset = model.getLocalData();
        notifyDataSetChanged();
    }

    // ViewHolder for Recycler View
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView codeName;
        private final TextView codeScore;

        public ViewHolder(View view) {
            super(view);
            codeName = view.findViewById(R.id.codelist_text_codename);
            codeScore = view.findViewById(R.id.codelist_text_codescore);
        }

        public TextView getCodeName() {
            return codeName;
        }
        public TextView getCodeScore() {
            return codeScore;
        }
    }
}
