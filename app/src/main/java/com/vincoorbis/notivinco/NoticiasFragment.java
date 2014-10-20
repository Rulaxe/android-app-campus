package com.vincoorbis.notivinco;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NoticiasFragment extends Fragment {
    List<Noticia> noticias = new ArrayList<Noticia>();
    NoticiasAdapter adapter;

    public static NoticiasFragment newInstance() {
        return new NoticiasFragment();
    }

    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        ListView lista = (ListView) rootView.findViewById(R.id.listView);

        adapter = new NoticiasAdapter(getActivity(), noticias);

        noticias.add(new Noticia("1", "Noticia uno", "Contenido", "Fecha", "Link imagen"));
        noticias.add(new Noticia("2", "Noticia dos", "Contenido", "Fecha", "Link imagen"));
        noticias.add(new Noticia("3", "Noticia tres", "Contenido", "Fecha", "Link imagen"));


        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Posicion " + i, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
