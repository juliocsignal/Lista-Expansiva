package listview.julio.com.expandablelistview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandableListView1);

        listView.setAdapter(new MeuAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MeuAdapter extends BaseExpandableListAdapter {

        Context context;

// Definindo o conteúdo de nossa lista e sublista

        String[] listaPai = { "  5 - 8 anos", "  9 - 12 anos", "  13 - 17 anos" };
        String[][] listafilho = { { "Gincana", "Gincana", "Gincana", "Gincana", "Gincana" },
                { "Gincana" , "Gincana", "Gincana", "Gincana", "Gincana"}, { "Gincana", "Gincana", "Gincana", "Gincana", "Gincana" } };

        public MeuAdapter(Context context) {
            this.context = context;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
// TODO Auto-generated method stub
            return listafilho[groupPosition][childPosition];
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
// TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

// Criamos um TextView que conterá as informações da listafilho que
// criamos
            TextView textViewSubLista = new TextView(context);
            textViewSubLista.setText(listafilho[groupPosition][childPosition]);
// Definimos um alinhamento
            textViewSubLista.setPadding(50, 20, 0, 20);
            textViewSubLista.setTextSize(25);

            return textViewSubLista;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
// TODO Auto-generated method stub
            return listafilho[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
// TODO Auto-generated method stub
            return listaPai[groupPosition];
        }

        @Override
        public int getGroupCount() {
// TODO Auto-generated method stub
            return listaPai.length;
        }

        @Override
        public long getGroupId(int groupPosition) {
// TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

// Criamos um TextView que conterá as informações da listaPai que
// criamos
            TextView textViewCategorias;
            textViewCategorias = new TextView(context);
            textViewCategorias.setText(listaPai[groupPosition]);
// Definimos um alinhamento
            textViewCategorias.setPadding(30, 10, 0, 10);
// Definimos o tamanho do texto
            textViewCategorias.setTextSize(25);
// Definimos que o texto estará em negrito
            textViewCategorias.setTypeface(null, Typeface.BOLD);

            return textViewCategorias;
        }

        @Override
        public boolean hasStableIds() {
// TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
// Defina o return como sendo true se vc desejar que sua sublista seja selecionável
            return false;
        }

    }
}
