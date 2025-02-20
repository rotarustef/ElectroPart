package electropart;

public class TableData {
    private int id;    
    private final String value;
    private final int qunatity;
    private final String footprint;
    private final String manufacturer;
    private final String location;
    private final String pdf;
    private String timestamp;
    
        public TableData(String value, Integer qunatity, String footprint, String manufacturer, String location, String pdf){
            this.id = 0;
            this.value = value;
            this.qunatity = qunatity;
            this.footprint = footprint;
            this.manufacturer = manufacturer;
            this.location = location;
            this.pdf = pdf;
            this.timestamp = "timestamp";
        }
    
        public int getId(){
            return this.id;
        }
    
        public void setId(int newId){
            this.id = newId;
        }
        
        public String getValue(){
            return this.value;
        }
    
        public int getQunatity(){
            return this.qunatity;
        }
    
        public String getFootprint(){
            return this.footprint;
        }
    
        public String getManufacturer(){
            return this.manufacturer;
        }
    
        public String getLocation(){
            return this.location;
        }
    
        public String getPdf(){
            return this.pdf;
        }
    
        public String getTimestamp() {
            return timestamp;
        }
    
        public void setTimestamp(String newTime) {
            this.timestamp = newTime;
    }
}
