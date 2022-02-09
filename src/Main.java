import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static int Ncomparacoes;
	
	public static void main(String[] args) throws IOException {
	
		  MyIO.setCharset("UTF-8");
		   Acomodacao[]vetordeItens = null;
		   Acomodacao[]vetor;
		   Acomodacao[]vetor2=null;
		   int[] Entrada1;
		   int [] Entrada2 = null;
			int tamanho=0, tamanho2=0;
			
			
			
			ArquivoTextoLeitura arquivoAcomodacoes = new ArquivoTextoLeitura("C:\\Users\\Fabio\\eclipse-workspace\\AIRBNBE/dados_airbnb.txt");
		  
			tamanho=Contalinhas(arquivoAcomodacoes);
			arquivoAcomodacoes = new ArquivoTextoLeitura("C:\\Users\\Fabio\\eclipse-workspace\\AIRBNBE/dados_airbnb.txt");
			vetordeItens=new Acomodacao[tamanho];
			vetordeItens=vetorAcomodacao(vetordeItens,tamanho, arquivoAcomodacoes);
		    arquivoAcomodacoes.fecharArquivo();
		  
		 
		
		    Entrada1=new int[tamanho];
		    Entrada1=EntradaParte1(Entrada1);
		    vetor=new Acomodacao[tamanho];
		    vetor=inserir(Entrada1,vetor, vetordeItens);
		    
		    for(int i=0; i<vetor.length;i++)
		    {
		    	if(vetor[i]!=null)
		    	System.out.println(vetor[i].getHostID());
		    }
		    /*
		    Entrada2=new int[tamanho];
		    
		    
		    Entrada2=EntradaParte2(Entrada2);
		    
		    long startTime = System.nanoTime();
		
		  
		    
		   vetor2=CorrigeTamanho(vetor,vetor2,tamanho2);
		    
		    mergeSort(vetor2);
		    
		    FazPesquisa(vetor2, Entrada2);
		    
		    
		    
			long endTime = System.nanoTime();
			
			long duration = (endTime - startTime);
		    
			//Imprimevetor(vetor);
			
			Criaarquivo(duration,Ncomparacoes);
		*/

	}
	
	public static int Contalinhas(ArquivoTextoLeitura arquivo) throws IOException
	{  
		int qtdLinha=0;
		String entrada=arquivo.ler();
		while(entrada!=null)
		  {
			  qtdLinha++;
			  entrada=arquivo.ler();
		  }
		
		arquivo.fecharArquivo();
		
		return qtdLinha;
	}
	public static void Imprimevetor(Acomodacao[]vetor)
	{
		for(int i=0; i<vetor.length;i++)
		{
			if(vetor[i]!=null)
			{
				System.out.println(vetor[i].imprimir());
			}
		}
	}
	public static Acomodacao[] inserir(int[]Entrada1, Acomodacao[]vetor, Acomodacao[]vetordeItens)
	{
		int contagem=0;
		
		for(int z=0;z<Entrada1.length;z++)
		{
			if(Entrada1[z]!=0)
			{
			
			for(int s=0; s<vetordeItens.length;s++)
			{
				
				
				
				try
				{
				    if(vetordeItens[s]!=null)
				    {
					if(Entrada1[z]==vetordeItens[s].getHostID())
					{
						
	                
						vetor[contagem]=vetordeItens[s];
					  
						
						contagem++;
						
						
						break;
					}
				    }
				}
				
				catch(Exception e)
				{
					System.out.println("O ERRO FOI :"+e);
				}
				
			}
			
			}
		}
			
		
		return vetor;
	}
	public static int[] EntradaParte1(int[] Entrada1)
	{
		String entradas=""; int i=0;
		
		entradas=MyIO.readLine();
            
		while(!entradas.equals("FIM"))
		{
			if(i>0)
			{
			entradas=MyIO.readLine();
			}
			if(!entradas.equals("FIM"))
			Entrada1[i]=Integer.parseInt(entradas);
			
			i++;
		}
		
		return Entrada1;
	}
	public static Acomodacao[] CorrigeTamanho(Acomodacao[]vetor,Acomodacao[]vetor2, int tamanho2)
	{
		int contagem=0;  
		for(int i=0; i<vetor.length;i++)
		    {
		    	if(vetor[i]!=null)
		    	{
		    		tamanho2++;
		    	}
		    }
		  vetor2=new Acomodacao[tamanho2];
		    
		    for(int i=0; i<vetor.length;i++)
		    {
		    	if(vetor[i]!=null)
		    	{
		    		vetor2[contagem]=vetor[i];
		    		
		    		contagem++;
		    	}
		    }
		    
		  
		  return vetor2;
		  
	}
	public static int[] EntradaParte2(int[] Entrada2)
	{
		
         String entradas=""; int i=0;
		
		 entradas=MyIO.readLine();
            
		  while(!entradas.equals("FIM"))
		{
			if(i>0)
			{
			entradas=MyIO.readLine();
			}
			if(!entradas.equals("FIM"))
			Entrada2[i]=Integer.parseInt(entradas);
			
			i++;
		}
	
		return Entrada2;
	}
	public static void FazPesquisa(Acomodacao[] vetor, int[]entrada2)
	{
		
		boolean Resposta;
		
		for(int i=0; i<entrada2.length;i++)
		{
			if(entrada2[i]!=0)
			{
			
			Resposta=pesquisaBinariaRecursiva(vetor,entrada2[i]);
				
			if(Resposta==true)
			{
				System.out.println("SIM");
			}
			else if(Resposta==false)
			{
				System.out.println("NAO");
			}
			}
		}
			
		
	}
	public static boolean pesquisaBinariaRecursiva(Acomodacao[] vet, int x) {
		return pesquisaBinariaRecursiva(vet, x, 0, (vet.length - 1));
		}
		public static boolean pesquisaBinariaRecursiva(Acomodacao[] vet, int x, int esq, int 
		dir) {
		boolean resp;
		int meio = (esq + dir) / 2;
		if (esq > dir) {
		resp = false;
		Ncomparacoes++;
		} else if (x == vet[meio].getHostID()) {
		resp = true;
		Ncomparacoes++;
		} else if (x > vet[meio].getHostID()) {
		resp = pesquisaBinariaRecursiva(vet, x, meio + 1, dir);
		Ncomparacoes++;
		} else {
		resp = pesquisaBinariaRecursiva(vet, x, esq, meio - 1);
		Ncomparacoes++;
		}
		return resp;
		}
		public static void mergeSort(Acomodacao[]vetor)
		{
			int tamanho = vetor.length;
		    
		    if (tamanho < 2) {
		      return;
		    }
		    
		    int metade = tamanho / 2;
		    Acomodacao[] Parteesq = new Acomodacao[metade];
		    Acomodacao[] ParteDireita = new Acomodacao[tamanho - metade];
		    
		    for (int i = 0; i < metade; i++) {
		      Parteesq[i] = vetor[i];
		    
		      
		    }
		    for (int i = metade; i < tamanho; i++) {
		      ParteDireita[i - metade] = vetor[i];
		     
		    }
		    
		    mergeSort(Parteesq);
		    mergeSort(ParteDireita);
		    
		    merge(vetor, Parteesq, ParteDireita);
		  }
			
		
		public static void merge(Acomodacao[] vetor, Acomodacao[]Parteesquerda, Acomodacao[]Partedireita)
		{
			
		
			
			int TamanhoEsq = Parteesquerda.length;
		    int TamanhoD = Partedireita.length;
		    
		    int i = 0, j = 0, k = 0;
		    
		    while (i < TamanhoEsq && j < TamanhoD)
		    {
		    	
		      if (Parteesquerda[i].getHostID() < Partedireita[j].getHostID()) {
		        vetor[k] = Parteesquerda[i];
		        i++;
		      }
		      else if(Parteesquerda[i].getHostID()==Partedireita[j].getHostID())
		      {
		    	  
		    	  if(Parteesquerda[i].getRoomID()==Partedireita[j].getRoomID())
		    	  {
		    		  vetor[k] = Parteesquerda[i];
		  	        i++;
		  	     
		    	  }
		    	  else
		    	  {
		    		vetor[k] = Partedireita[j];
		  	        j++;
		  	     
		    	  }
		      }
		      else {
		        vetor[k] = Partedireita[j];
		        j++;
		        
		      }
		      k++;
		    }
		    
		    while (i < TamanhoEsq) {
		      vetor[k] = Parteesquerda[i];
		      i++;
		      k++;
		    
		    }
		    
		    while (j < TamanhoD) {
		      vetor[k] = Partedireita[j];
		      j++;
		      k++;
		     
		    }
		}

	public static Acomodacao[] vetorAcomodacao(Acomodacao[]vetordeItens,int tamanho, ArquivoTextoLeitura arquivo) throws IOException
	{
		int roomID=0,hostID=0,reviews=0,accomodates=0;
		String roomType="",country="",city="",neighbourhood="",propertyType="";
		double overallSatisfaction=0,price=0,bedrooms=0;
	
		
		String Linha;

	
		
		vetordeItens=new Acomodacao[tamanho];
		
		Linha=arquivo.ler();
	
		
		
	try
	{
	
		for(int i=0;i<vetordeItens.length;i++)
	
		{
			   Linha=arquivo.ler();
				if(Linha!=null)
				{
		    	String[] separa=null;
		    	separa=Linha.trim().split("\\t");
		        
		    	 roomID=Integer.parseInt(separa[0]);
			     hostID=Integer.parseInt(separa[1]);
				 roomType=separa[2];
				 country=separa[3];
			     city=separa[4];
			     neighbourhood=separa[5];
			     reviews=Integer.parseInt(separa[6]);
			     overallSatisfaction=Double.parseDouble(separa[7]);
			     accomodates=Integer.parseInt(separa[8]);
			     bedrooms=Double.parseDouble(separa[9]);
			     price=Double.parseDouble(separa[10]);
			     propertyType=separa[11];
			     
			     vetordeItens[i]=new Acomodacao(roomID,hostID,roomType,country,city,neighbourhood,reviews, overallSatisfaction,accomodates,bedrooms, price, propertyType);
			     
				}
				
		 }
	

	}
	
	
	catch(Exception e) {
		System.out.println("");
	}
	
	
	
		
		return vetordeItens;
	}
	

public static void Criaarquivo(long duracao, int vezescomparadas) throws IOException
{
	String arquivo="matricula_binaria.txt ";
	
	 try {
         // Conteudo
		 String texto="Matricula:674270  "+"Tempo de Execucao(ms): "+duracao+"  Numero de comparacoes:"+vezescomparadas;

         // Cria arquivo
         File file = new File(arquivo);

         // Se o arquivo nao existir, ele gera
         if (!file.exists()) {
             file.createNewFile();
         }

         // Prepara para escrever no arquivo
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         
         // Escreve e fecha arquivo
         bw.write(texto);
         bw.close();
         
      

     } catch (IOException e) {
         e.printStackTrace();
     }
	
	
	
	
	
}
}
class Acomodacao {
	private int roomID,hostID,reviews,accomodates;
	 private String roomType,country,city,neighbourhood,propertyType;
	 private double overallSatisfaction,price,bedrooms;
	
	 public Acomodacao(int roomID,int hostID,String roomType,String country, String city, String neighbourhood,int reviews,double overallSatisfaction,int accomodates, double bedrooms,double price,String propertyType)
			
	 {
		 
		 this.roomID=roomID;
		 this.hostID=hostID;
		 this.reviews=reviews;
		 this.accomodates=accomodates;
		 this.roomType=roomType;
		 this.country=country;
		 this.city=city;
		 this.neighbourhood=neighbourhood;
		 this.propertyType=propertyType;
		 this.overallSatisfaction=overallSatisfaction;
		 this.price=price;
		 this.bedrooms=bedrooms;
	 }
	 
	
	 public Acomodacao() {}
		 

	
	 public int getRoomID() {
			return roomID;
		}

		public void setRoomID(int roomID) {
			this.roomID = roomID;
		}

		public int getHostID() {
			return hostID;
		}

		public void setHostID(int hostID) {
			this.hostID = hostID;
		}

		public int getReviews() {
			return reviews;
		}

		public void setReviews(int reviews) {
			this.reviews = reviews;
		}

		public int getAccomodates() {
			return accomodates;
		}

		public void setAccomodates(int accomodates) {
			this.accomodates = accomodates;
		}

		public String getRoomType() {
			return roomType;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getNeighbourhood() {
			return neighbourhood;
		}

		public void setNeighbourhood(String neighbourhood) {
			this.neighbourhood = neighbourhood;
		}

		public String getPropertyType() {
			return propertyType;
		}

		public void setPropertyType(String propertyType) {
			this.propertyType = propertyType;
		}

		public double getOverallSatisfaction() {
			return overallSatisfaction;
		}

		public void setOverallSatisfaction(double overallSatisfaction) {
			this.overallSatisfaction = overallSatisfaction;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getBedrooms() {
			return bedrooms;
		}

		public void setBedrooms(double bedrooms) {
			this.bedrooms = bedrooms;
		}

	 public Acomodacao clone() {
		 Acomodacao copia;
		 copia=new Acomodacao(this.roomID,this.hostID,this.roomType,this.country,
				 this.city,this.neighbourhood,this.reviews,this.overallSatisfaction,
				 this.accomodates,this.bedrooms,this.price,this.propertyType);
		 return copia;
	 }
	 


	

	
	 public String imprimir() {
		 
		 String imprime="";
		if(hostID!=0)
		 {
			 return imprime= "["+roomID+" ## "+hostID+" ## "+roomType+" ## "+
					 country+" ## "+city+" ## "+neighbourhood+" ## "+reviews+" ## "+
								 overallSatisfaction+" ## "+accomodates+" ## "+
					 bedrooms+" ## "+price+" ## "+propertyType+"]";
		 }
		return imprime;
	 }
	 
	 }	

class ArquivoTextoLeitura {

	private BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	@SuppressWarnings("finally")
	public String ler() {
		
		String textoEntrada = null;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) {
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}
