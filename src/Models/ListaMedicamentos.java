package Models;

import java.util.ArrayList;


public class ListaMedicamentos {
    
    ArrayList <Medicamento> medicamentos = new ArrayList<>();
    
    public ListaMedicamentos(){
        medicamentos.add(new Medicamento("Gardasil9","Papiloma Humano","MSD","234","IV","5/02/2030",4500));  
        medicamentos.add(new Medicamento("Evista","raloxifeno","ELY LILLY Y COMPAÑIA DE MEXICO, S.A. DE C.V.","234","IV","5/02/2030",1902));
        medicamentos.add(new Medicamento("Cosmegen_solucion_inyectable_0.5mg","Dactomicina","ARMSTRONG","234","IV","5/02/2030",14500));
        medicamentos.add(new Medicamento("XGEVA_SOLUCION_INYECTABLE_120MG-1.7ML","denosumab","","234","IV","5/02/2030",4500));
        medicamentos.add(new Medicamento("BLEOMAX","Bleomicina","CRYROPHARMA","234","IV","5/02/2030",4500));  
        medicamentos.add(new Medicamento("SOMAXITEL","Docetaxel","LEMERY S.A DE C.V","234","IV","5/02/2030",4473));
        medicamentos.add(new Medicamento("Clofazic","Clofarabina","GENZYME","234","IV","5/02/2030",52853));
        medicamentos.add(new Medicamento("DOXORUBCINA","Doxorubicina","LABORATORIOS COLUMBIA S.A DE C.V","234","IV","5/02/2030",385));
        medicamentos.add(new Medicamento("DTI_SOLUCIÓN_200MG","Dacarbazima","KOREA UNITED PHARM","234","IV","5/02/2030",115));
        medicamentos.add(new Medicamento("OPDIVO_SOLUCION_INYECTABLE_1000MG-10ML","Nivolumab","","234","IV","5/02/2030",38119));
    }
    
    
    public Medicamento buscarmedicamentos(String nombre){
        for (Medicamento medicamento : medicamentos){
            if(medicamento.getNombreComercial().equals(nombre)){
                return medicamento;
                
            }
        }
        return null;
    }


	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}
    
}
