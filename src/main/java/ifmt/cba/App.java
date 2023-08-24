package ifmt.cba;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import ifmt.cba.servico.AtendeCliente;
import ifmt.cba.servico.EnderecoERP;
import ifmt.cba.servico.SQLException_Exception;
import ifmt.cba.servico.SigepClienteException;
public class App 
{
    public static void main( String[] args )  {
        URL url;
        try {
            url = new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");
            QName qname = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "AtendeClienteService");
            Service service = Service.create(url, qname);

            AtendeCliente correios = service.getPort(AtendeCliente.class);
            EnderecoERP endereco = correios.consultaCEP("78055584");
            System.out.println("==================");
            System.out.println("Cidade..."+ endereco.getCidade());
            System.out.println("Bairro..."+ endereco.getBairro());
            System.out.println("UF..."+ endereco.getUf());
            System.out.println("Endereço..."+ endereco.getEnd());
             System.out.println("==================");
        } catch (MalformedURLException e) {
           e.printStackTrace();
        } catch (SQLException_Exception e){
            e.printStackTrace();
        } catch (SigepClienteException e){
            e.printStackTrace();
        }

        }
  
    }

