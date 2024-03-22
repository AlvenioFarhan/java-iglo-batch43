import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Treatment {

    private String startTreatment;
    private String endTreatment;
    private Patient patientID;
    private LogMedicalCheckup logMedicalCheckup;
    private LogMediation logMediation;
    private LogTherapy logTherapy;


    public Treatment() {
    }

    public Treatment(String startTreatment, Patient patientID) {
        this.startTreatment = startTreatment;
        this.patientID = patientID;
    }

    public Treatment(String startTreatment, String endTreatment, Patient patientID) {
        this.startTreatment = startTreatment;
        this.endTreatment = endTreatment;
        this.patientID = patientID;
    }

    public String getStartTreatment() {
        return startTreatment;
    }

    public void setStartTreatment(String startTreatment) {
        this.startTreatment = startTreatment;
    }

    public String getEndTreatment() {
        return endTreatment;
    }

    public void setEndTreatment(String endTreatment) {
        this.endTreatment = endTreatment;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    //print all treantment
    public void printAllTreatmentMedicalCheckup() {
//        LocalDate startTime = LocalDate.parse(startTreatment);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(String.copyValueOf(startTreatment));
//        calendar.add(Calendar.MINUTE, 15);
//        Date endTime = calendar.getTime();
//
//        // Format waktu selesai
//        String endTimeFormatted = dateFormat.format(endTime);
        System.out.println("[Medical Checkup] - Method: Magnetic Resonance Imaging, Doctor: Dr Amelia");
        System.out.printf("[Medical Checkup] - Method: Magnetic Resonance Imaging, Doctor: Dr Amelia");
        System.out.println("02-02-2023 09:30 - 02-02-2023 09:45, Patient: Jill");
    }

    public void printAllTreatment(){
        for (LogMedicalCheckup listMedicalCheckup : Horus.getLogMedicalCheckups()){
            System.out.println("==============================");
            System.out.println("Medical Checkup");
            System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Dokter: %s \n",
                    logMedicalCheckup.getPatient(),logMedicalCheckup.getTanggalMasukTreatment(), endTreatment,
                    logMedicalCheckup.getDurasi(), logMedicalCheckup.getNamaDokter());
            System.out.println("==============================");
        }
        for (LogMediation logMediation : Horus.getLogMediations()){
            System.out.println("==============================");
            System.out.println("Medication");
            System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Medication: %s, Quantity Medication: %s \n",
                    logMediation.getIdPatient(),logMediation.getTanggalMasukTreatment(), endTreatment, logMediation.getDurasi(),
                    logMediation.getNamaMediation(), logMediation.getQuantityMediation());
            System.out.println("==============================");
        }
        for (LogTherapy logTherapy : Horus.getLogTherapies()){
            System.out.println("==============================");
            System.out.println("Therapy");
            System.out.printf("Nama: %s, Tanggal Check Up: %s - %s, Durasi: %s Menit, Nama Treatment: %s, Nama Therapist: %s \n",
                    logTherapy.getIdPatient(),logTherapy.getTanggalMasukTreatment(), endTreatment, logTherapy.getDurasi(),
                    logTherapy.getNamaTreatment(), logTherapy.getNamaTherapyst());
            System.out.println("==============================");
        }
    }

}
