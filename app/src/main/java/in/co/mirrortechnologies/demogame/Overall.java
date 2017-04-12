package in.co.mirrortechnologies.demogame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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

public class Overall extends Activity implements View.OnClickListener {
    private static final String SELECT_SQL = "SELECT * FROM sample";
    private SQLiteDatabase db;
    private Cursor c,c1,c2,c3,cs;
    TextView tv0,tv1,tv2,tv3,v0,v1,v2,v3,view;
    int width,height;
    TableLayout tl;
    TableRow tr,tr1;
    String item1;
    String name,score;
   String SELECT_SQL1,SELECT_SQL2,SELECT_SQL3,same;
    Button b6,b7;

String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_list_overall);
        openDatabase();
        b6= (Button) findViewById(R.id.button6);

        c = db.rawQuery(SELECT_SQL, null);
        c.moveToLast();
        name=c.getString(1);
        score=c.getString(2);
        c.moveToFirst();
        SELECT_SQL1 = "SELECT * FROM sample WHERE name= '" + name + "'  order by score desc";
        c1 = db.rawQuery(SELECT_SQL1, null);
        c1.moveToFirst();
        view=new TextView(this);
        tl = (TableLayout) findViewById(R.id.maintable);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
        c1.moveToFirst();
            addHeaders();
modify();
        addData();
            delete();


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Overall.this,People.class);
                startActivity(i1);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

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
        tv0.setTextColor(Color.GRAY);
        tv0.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tv0.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv0.setPadding(0,5,4, 0);
        tv1 = new TextView(this);
        tv1.setText("ID");
        tv1.setTextColor(Color.GRAY);
        tv1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv1.setPadding(4,5,4, 0);
        tr.addView(tv1);
        tv2 = new TextView(this);
        tv2.setText("Name");
        tv2.setTextColor(Color.GRAY);
        tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv2.setPadding(4, 5,0, 0);
        tv2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(tv2);
        tv3 = new TextView(this);
        tv3.setText("Score ");
        tv3.setTextColor(Color.GRAY);
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
        divider0.setTextColor(Color.GREEN);
        divider0.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider0.setPadding(0, 0, 0, 0);
        divider0.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider0);
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(Color.GREEN);
        divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider);
        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(Color.GREEN);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2);
        TextView divider3 = new TextView(this);
        divider3.setText("-------------------------");
        divider3.setTextColor(Color.GREEN);
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
        c1.moveToFirst();
        int j=1;
        if(c1.getCount()==1)
        {
            String id = c1.getString(0);
            String name = c1.getString(1);
            String score = c1.getString(2);
            v0 = new TextView(this);
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
        }
        else {


            if (!c1.isLast()) {
                while (!c1.isAfterLast()) {
                    String id = c1.getString(0);
                    String name = c1.getString(1);
                    String score = c1.getString(2);
                    v0 = new TextView(this);
                    v0.setText(id);
                    tr1 = new TableRow(this);
                    v1 = new TextView(this);
                    v1.setText(Integer.toString(j));
                    v1.setTextColor(Color.GRAY);
                    tr1.addView(v1);
                    v2 = new TextView(this);
                    v2.setText(name);
                    v2.setTextColor(Color.GRAY);
                    tr1.addView(v2);
                    v3 = new TextView(this);
                    v3.setText(score);
                    v3.setTextColor(Color.GRAY);
                    tr1.addView(v3);
                    tr1.setClickable(true);
                    tl.addView(tr1, new TableLayout.LayoutParams(
                            LayoutParams.FILL_PARENT,
                            LayoutParams.WRAP_CONTENT));
                    j++;
                    c1.moveToNext();
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
            c1.moveToNext();
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
                        String sql1="delete from sample";
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
    public void classify()
    {
        c1.moveToFirst();

        if(c1.getCount()>1)
        {
            SELECT_SQL2 = "SELECT name, max(score) as score FROM sample where name= '"+name+"'";
            c2 = db.rawQuery(SELECT_SQL2, null);
            c2.moveToFirst();
            String n1=c2.getString(0);
            String s1=c2.getString(1);

            SELECT_SQL3= "SELECT * FROM leader WHERE name= '" + name + "'  order by score desc";
            c3 = db.rawQuery(SELECT_SQL3, null);
            c3.moveToFirst();
            if(c3.getCount()==1)
            {
                String q2="UPDATE leader SET score="+s1+" WHERE name = '" + name + "';";
                db.execSQL(q2);
            }
            else
            {
                String query = "INSERT  INTO leader (name,score) VALUES('"+n1+"', '"+s1+"');";
                db.execSQL(query);
            }}



       else
        {
            String n1=c1.getString(1);
            String s1=c1.getString(2);
            String query = "INSERT  INTO leader (name,score) VALUES('"+n1+"', '"+s1+"');";
            db.execSQL(query);

        }

    }
    public void modify()
    {   SELECT_SQL2 = "SELECT name, max(score) as score FROM sample where name= '"+name+"'";
        c2 = db.rawQuery(SELECT_SQL2, null);
        c2.moveToFirst();
        String n1=c2.getString(0);
        String s1=c2.getString(1);
        String same="SELECT name,score FROM leader WHERE (score= " + Integer.parseInt(s1) + " AND name = '"+n1 +"');";
        Cursor cs=db.rawQuery(same,null);
        Toast.makeText(this, "Classify"+cs.getCount(), Toast.LENGTH_SHORT).show();
        if(c1.getCount()==1) {
            if (cs.getCount() == 0) {
                String n2=c1.getString(1);
                String s2=c1.getString(2);
                String query = "INSERT  INTO leader (name,score) VALUES('"+n2+"', '"+s2+"');";
                db.execSQL(query);
            }
            else
            {

            }
        }
        else
        {SELECT_SQL3= "SELECT * FROM leader WHERE name= '" + name + "'  order by score desc";
            c3 = db.rawQuery(SELECT_SQL3, null);
            c3.moveToFirst();
            String q2="UPDATE leader SET score="+s1+" WHERE name = '" + name + "';";
            db.execSQL(q2);

        }

    }

}
