import java.util.*;

public class Horus {

    private static Map<String, Patient> patients = new HashMap<>();
    private static Map<String, MedicalCheckup> medicalCheckupMap = new HashMap<>();
    private static List<ChronicDisease> chronicDiseases = new ArrayList<>();
    private static List<Treatment> treatments = new ArrayList<>();
    private static List<LogMedicalCheckup> logMedicalCheckups = new ArrayList<>();
    private static List<LogMediation> logMediations = new ArrayList<>();
    private static List<LogTherapy> logTherapies = new ArrayList<>();

    public static void initializeLogData(){

    }

    //Data Medical checkup
    public static void intializeDataMedicallCheckup() {

        medicalCheckupMap.put("CT", new MedicalCheckup("CT", "CT Scan"));
        medicalCheckupMap.put("MRI", new MedicalCheckup("MRI", "Magnetic Resonance Imaging"));
        medicalCheckupMap.put("BP", new MedicalCheckup("BP", "Blood Pressure"));
        medicalCheckupMap.put("LAB", new MedicalCheckup("LAB", "Laboratory Test"));
        medicalCheckupMap.put("ECG", new MedicalCheckup("ECG", "Electrocardiogram"));

    }

    public static Map<String, Patient> getPatients() {
        return patients;
    }

    //menambah data patient
    public static void addDataPatient(Patient patient) {
        patients.put(patient.getIdPatient(), patient);
    }

    //add LogMedical Checkup
    public static void addDataLogMedicalCheckup(LogMedicalCheckup logMedicalCheckup) {
        logMedicalCheckups.add(logMedicalCheckup);
    }

    //Log mediation
    public static void addDataLogMediation(LogMediation logMediation) {
        logMediations.add(logMediation);
    }

    //log therapy
    public static void addDataLogTherapy(LogTherapy logTherapy) {
        logTherapies.add(logTherapy);
    }

    //Get data log
    public static List<LogMedicalCheckup> getLogMedicalCheckups() {
        return logMedicalCheckups;
    }

    //get data log
    public static List<LogMediation> getLogMediations() {
        return logMediations;
    }

    //get data log
    public static List<LogTherapy> getLogTherapies() {
        return logTherapies;
    }

    //menambah data penyakit
    public static void addDataPenyakit(ChronicDisease chronicDisease) {
        chronicDiseases.add(chronicDisease);
    }

    //replace data patient yang sama Id nya
    public static void replacePatientDoubleID(String idPatient) {
        Patient patient = patients.get(idPatient);
        if (patient != null) {
            System.out.println("Patient dengan id tersebut sudah ada. Data akan diperbarui.");
            patients.remove(idPatient);
        }
    }

    //print all data patient
    public static void printAllDataPatient() {
        if (patients.isEmpty()) {
            System.out.println("tidak ada patients");
        } else {
            for (Patient patient : patients.values()) {
                patient.printAllDataMenuPatient();
                if (chronicDiseases != null && patient.getAge() >= 65) {
                    for (ChronicDisease chronicDisease : chronicDiseases) {
                        chronicDisease.printAllDataChronicDisiase();
                    }
                }
                System.out.println("==============================");
            }
        }
    }

    //print all data medical checkup
    public static void printAllDataMedicalCheckup() {
        for (MedicalCheckup medicalCheckup : medicalCheckupMap.values()) {
            medicalCheckup.printAllMedicalCheckup();
        }
    }

    public static Patient findPatientByID(String patientId) {
        // Find the selected patient

        if (patientId == null) {
            System.out.println("Patient tidak ditemukan.");
        }
        return patients.get(patientId);
    }

    // Method to list treatment schedule
    static void listTreatmentSchedule(Scanner scanner) {
        if (treatments.isEmpty()) {
            System.out.println("Tidak ada jadwal perawatan.");
            Main.mainMenu(scanner);
        } else {
            System.out.println("Jadwal Perawatan:\n");
            for (Treatment treatment : treatments) {
//                treatment.printAllTreatmentMedicalCheckup();
                treatment.printAllTreatment();
            }
        }
    }

    // cek slot masih ada atau tidak
    static boolean isSlotAvailable(String startTime) {
        for (Treatment treatment : treatments) {
            if (treatment.getStartTreatment().equals(startTime)) {
                return false;
            }
        }
        return true;
    }

    //validate code checkup
    static boolean isValidCodeCheckup(String codeCheckup) {
        for (MedicalCheckup medicalCheckup : medicalCheckupMap.values()) {
            if (medicalCheckup.getCodeMedicalCheckup().equals(codeCheckup)) {
                return true;
            }
        }
        return false;
    }


    public static void printKaryawan(HashMap<Integer, String> employees){

        for ( var karyawan : employees.values() ){

        }
    }


}

