package com.example.AdapterHistory;

import android.app.LauncherActivity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizappvi.R;
import com.example.quizappvi.ui.fragments.ClassHis;

import java.util.ArrayList;

public class AdapterH  extends RecyclerView.Adapter<AdapterH.ViewHolderH>  {


  private ArrayList <ClassHis> list ;
private Context context;


    public AdapterH(ArrayList<ClassHis> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View layoutInflater=  LayoutInflater.from(parent.getContext()).inflate(R.layout.listh,parent,false);


        return new ViewHolderH(layoutInflater)  ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderH holder, int position) {
        ClassHis classHis=list.get(position);
         holder.textCategory.setText(classHis.getTextCategory());
         holder.textClock.setText(classHis.getTextClock());
         holder.textMixed.setText(classHis.getTextMixed());
         holder.textCorrectAnswers.setText(classHis.getTextCorrectAnswers());
         holder.textDifficulty.setText(classHis.getTextDifficulty());
         holder.textEasy.setText(classHis.getTextEasy());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class ViewHolderH extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
   public     TextView textCategory,textMixed,textClock,textCorrectAnswers,textDifficulty,textEasy;
    public ImageButton imageButton;
    private static  final String TAG="MyViewHolder";


        public ViewHolderH(@NonNull View itemView) {
            super(itemView);
            textCategory=itemView.findViewById(R.id.category);
            textMixed=itemView.findViewById(R.id.mixed);
            textClock=itemView.findViewById(R.id.clock);
            textCorrectAnswers=itemView.findViewById(R.id.correct_answers);
            textDifficulty=itemView.findViewById(R.id.difficulty);
            textEasy=itemView.findViewById(R.id.easy);
                imageButton=itemView.findViewById(R.id.menu_dots);
imageButton.setOnClickListener(this);



        }


        @Override
        public void onClick(View v) {
            Log.d(TAG,"onclick"+getAdapterPosition());
   showPopupMenu(v);

        }

        private void showPopupMenu(View view) {


            PopupMenu popupMenu=new PopupMenu(view.getContext(),view);
            popupMenu.inflate(R.menu.history_menu);

          popupMenu.setOnMenuItemClickListener(this);
           popupMenu.show();

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

           switch ((item.getItemId())){

               case R.id.deleteH:
                   return  true;
               case R.id.createH:
                   return  true;
               case R.id.change_colorH:
                   return true;
               default:
                   return false;

           }



        }
    }
}
