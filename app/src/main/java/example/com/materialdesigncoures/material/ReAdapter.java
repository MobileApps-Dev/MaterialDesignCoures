package example.com.materialdesigncoures.material;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 6/29/16.
 */
public class ReAdapter extends RecyclerView.Adapter<ReAdapter.MyViewHolder> {

    List<Modal> mData;
    LayoutInflater inflater;

    public ReAdapter(Context context, List<Modal> mData) {
        this.mData = mData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Modal modal = mData.get(position);
        holder.setData(modal, position);
        holder.setLinster();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, desc;
        ImageView img, delete, add;
        int position;
        Modal modal;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            img = (ImageView) itemView.findViewById(R.id.img);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            add = (ImageView) itemView.findViewById(R.id.add);
        }

        public void setData(Modal modal, int position) {
            this.title.setText(modal.getTitle());
            this.img.setImageResource(modal.getImage());
            this.position = position;
            this.modal = modal;
        }

        public void setLinster() {
            delete.setOnClickListener(MyViewHolder.this);
            add.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.delete:
                    removeItem(position);
                    break;

                case R.id.add:
                    addItem(position, modal);
                    break;
            }
        }
    }

    private void addItem(int position, Modal modal) {
        mData.add(position, modal);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mData.size());
    }


    private void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mData.size());

    }
}
