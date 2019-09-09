/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author memol
 */
public class Lista {
    Nodo inicio=null;
    Nodo fin=null;
    
    void insertar (int dato){
        Nodo nuevo= new Nodo();
        nuevo.dato=dato;
        nuevo.sig=null;
        nuevo.ant=null;
        if((inicio==null)&&(fin==null)){
            inicio=nuevo;
            fin=nuevo;
        }else{
            nuevo.sig=inicio;
            inicio.ant=nuevo;
            inicio=nuevo;
        }
    }
    void suma(Lista lista1, Lista lista2){
        Nodo aux1=lista1.fin;
        Nodo aux2=lista2.fin;
        Lista resultado=new Lista();
        int acarreo=0;
        int digito=0;
        while((aux1!=null)&&(aux2!=null)){
            int suma=aux1.dato+aux2.dato+acarreo;
            acarreo=suma/10;
            digito=suma%10;
            resultado.insertar(digito);
            aux1=aux1.ant;
            aux2=aux2.ant;
        }
        Nodo temp=aux1==null ? aux2:aux1;
        while(temp!=null){
            int suma=temp.dato+acarreo;
            acarreo=suma/10;
            digito=suma%10;
            resultado.insertar(digito);
            temp=temp.ant;
        }
        if(acarreo>0){
            resultado.insertar(acarreo);
        }
        resultado.Imprimir();
    }
    void resta(Lista lista1, Lista lista2){
        Nodo aux1=lista1.fin;
        Nodo aux2=lista2.fin;
        Nodo acarreo=lista1.fin;
        Lista resultado=new Lista();
        while((aux1!=null)&&(aux2!=null)){
            if(aux2.dato>aux1.dato){
                while(aux1.dato<aux2.dato){
                    acarreo=acarreo.ant;
                    if(acarreo.dato==0){
                        acarreo.dato=9;
                    }else{
                        acarreo.dato--;
                        aux1.dato+=10;
                    }
                }
            }
            int resta=aux1.dato-aux2.dato;
            resultado.insertar(resta);
            aux1=aux1.ant;
            aux2=aux2.ant;
            acarreo=aux1;
        }
        Nodo temp=aux1==null ? aux2:aux1;
        while(temp!=null){
            int resta=temp.dato;
            resultado.insertar(resta);
            temp=temp.ant;
        }
        resultado.Imprimir();
    }
    void Multiplicacion (Lista lista1, Lista lista2){
        Nodo aux2=lista2.fin;
        Lista resultado=new Lista();
        while(aux2!=null){
            Nodo aux1=lista1.fin;
            Lista multiplo=new Lista();
            int acarreo=0;
            int digito;
            while(aux1!=null){
                int multi=aux1.dato*aux2.dato+acarreo;
                acarreo=multi/10;
                digito=multi%10;
                multiplo.insertar(digito);
                aux1=aux1.ant;
            }
            multiplo.insertar(acarreo);
            if((resultado.inicio==null)&&(resultado.fin==null)){
                Nodo aux=multiplo.fin;
                while(aux!=null){
                    resultado.insertar(aux.dato);
                    aux=aux.ant;
                }
            }else{
                Nodo aux3=resultado.fin.ant;
                Lista listTemp=new Lista();
                listTemp.sumaMulti(resultado, multiplo, aux3);
            }
            aux2=aux2.ant;
            multiplo.eliminar();
        }
        resultado.Imprimir();
    }
    void sumaMulti(Lista lista1, Lista lista2, Nodo aux){
	Nodo aux1=aux;
	Nodo aux2= lista2.fin;
	int acarreo=0;
	int digito=0;
	while((aux1!=null) && (aux2!=null)){
		int suma=aux1.dato + aux2.dato + acarreo;
		acarreo=suma/10;
		digito=suma%10;
		aux1.dato=digito;
		aux1=aux1.ant;
		aux2=aux2.ant;
	}
	Nodo temp=aux1==null ? aux2:aux1;
	while(temp!=null){
		int suma=temp.dato+acarreo;
		acarreo=suma/10;
		digito=suma%10;
		lista1.insertar(digito);
		temp=temp.ant;
	}
	if(acarreo>0){
		lista1.insertar(acarreo);		
	}
    }
    void eliminar(){
        if(inicio!=null){
            inicio=null;
        }
    }
    void Imprimir(){
        if(inicio!=null){
            Nodo aux=inicio;
            while(aux!=null){
                System.out.print(aux.dato);
                aux=aux.sig;
            }
            System.out.println("");
        }
    } 
}
