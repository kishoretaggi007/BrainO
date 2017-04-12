package in.co.mirrortechnologies.demogame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;
import static java.security.AccessController.getContext;

public class People extends Activity implements View.OnClickListener {
    private static final String SELECT_SQL = "SELECT * FROM leader order by score desc";

    private SQLiteDatabase db;
    private Cursor c;
    TextView tv0,tv1,tv2,tv3,v0,v1,v2,v3,view;
    int width,height;
    TableLayout tl;
    TableRow tr,tr1;
    Button b1;
    String item1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_list);
        openDatabase();
        c = db.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        view=new TextView(this);
        b1= (Button) findViewById(R.id.finalButton);
        tl = (TableLayout) findViewById(R.id.maintable);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(People.this, AppOnOpen.class);
                startActivity(icl);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
       addHeaders();
        addData();
        delete();
    }
    protected void openDatabase() {
        db = openOrCreateDatabase("ScoreList", Context.MODE_PRIVATE, null);
    }
    public void addHeaders()
    {
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        tv0 = new TextView(this);
        tv0.setText("NOT");
        tv0.setTextColor(rgb(165,42,42));
        tv0.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tv0.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv0.setPadding(0,5,4, 0);
        tv1 = new TextView(this);
        tv1.setText("ID");
        tv1.setTextColor(rgb(165,42,42));
        tv1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv1.setPadding(4,5,4, 0);
        tr.addView(tv1);
        tv2 = new TextView(this);
        tv2.setText("Name");
        tv2.setTextColor(rgb(165,42,42));
        tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv2.setPadding(4, 5,0, 0);
        tv2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(tv2);
        tv3 = new TextView(this);
        tv3.setText("Score ");
        tv3.setTextColor(rgb(165,42,42));
        tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv3.setPadding(0, 5,5, 0);
        tv3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(tv3);
        tl.addView(tr, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        TextView divider0 = new TextView(this);
        divider0.setText("-----------------");
        divider0.setTextColor(rgb(255,215,0));
        divider0.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider0.setPadding(0, 0, 0, 0);
        divider0.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider0);
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(rgb(255,215,0));
        divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider);
        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(rgb(255,215,0));
        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2);
        TextView divider3 = new TextView(this);
        divider3.setText("-------------------------");
        divider3.setTextColor(rgb(255,215,0));
        divider3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider3.setPadding(5, 0, 0, 0);
        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider3);
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }
    public void addData()

    {
        c.moveToFirst();
        int j = 1;
        if (c.getCount() == 1) {
            String id = c.getString(0);
            String name = c.getString(1);
            String score = c.getString(2);
            v0 = new TextView(this);
            v0.setText(id);
            tr1 = new TableRow(this);
            v1 = new TextView(this);
            v1.setText(Integer.toString(j));
            tr1.addView(v1);
            v2 = new TextView(this);
            v2.setText(name);
            tr1.addView(v2);
            v3 = new TextView(this);
            v3.setText(score);
            tr1.addView(v3);
            tr1.setClickable(true);
            tl.addView(tr1, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        } else {
            if (!c.isLast()) {
                while (!c.isAfterLast()) {
                    String id = c.getString(0);
                    String name = c.getString(1);
                    String score = c.getString(2);
                    v0 = new TextView(this);
                    v0.setText(id);
                    tr1 = new TableRow(this);
                    v1 = new TextView(this);
                    v1.setText(Integer.toString(j));
                    v1.setTextColor(rgb(255,0,0));
                    tr1.addView(v1);
                    v2 = new TextView(this);
                    v2.setText(name);
                    v2.setTextColor(rgb(255,0,0));
                    tr1.addView(v2);
                    v3 = new TextView(this);
                    v3.setText(score);
                    v3.setTextColor(rgb(255,0,0));
                    tr1.addView(v3);
                    tr1.setClickable(true);

                    tl.addView(tr1, new TableLayout.LayoutParams(
                            LayoutParams.FILL_PARENT,
                            LayoutParams.WRAP_CONTENT));
                    j++;
                    c.moveToNext();
                }

            }
        }
    }
    public void delete() {
        for(int i=1;i<=c.getCount();i++)
        {
            v1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onClick(v);
                    return true;
                }
            });
            v2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onClick(v);
                    return true;
                }
            });
            v3.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onClick(v);
                    return true;
                }
            });
            c.moveToNext();
        }

    }




    @Override
    public void onClick(View v)
    {item1=v0.getText().toString();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want delete this person?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                      //String sql1="delete from leader where id="+item1+";";
                       String sql1="delete  from leader ";

                        db.execSQL(sql1);
                        Toast.makeText(getApplicationContext(),"Deleted", Toast.LENGTH_SHORT).show();
                    }
                });


        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
