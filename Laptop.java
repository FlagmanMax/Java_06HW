public class Laptop {
    private Integer id;
    private String productName;
    private Float displaySizeInInches; 
    private Integer romSize;
    private Integer ramSize;
    private String osType;
    private Float price;

    /**
     * @param id
     * @param productName
     * @param displaySizeInInches
     * @param romSize
     * @param ramSize
     * @param osType
     * @param price
     */
    public Laptop(  Integer id,
                    String productName,
                    Float displaySizeInInches,
                    Integer romSize,
                    Integer ramSize,
                    String osType,
                    Float price)
    {
        this.id = id;
        this.productName = productName;
        this.displaySizeInInches = displaySizeInInches;
        this.romSize = romSize;
        this.ramSize = ramSize;
        this.osType = osType;
        this.price = price;
    }

    public void printInfo()
    {
        System.out.printf("\tid:                 \t%d\n",id);
        System.out.printf("\tНаименование:       \t%s\n",productName);
        System.out.printf("\tРазмер экрана, дюйм:\t%.1f\n",displaySizeInInches);
        System.out.printf("\tРазмер ROM, ГБ:     \t%d\n",romSize);
        System.out.printf("\tРазмер RAM, ГБ:     \t%d\n",ramSize);
        System.out.printf("\tТип ОС:             \t%s\n",osType);
        System.out.printf("\tЦена:               \t%.2f\n",price);
        System.out.printf("\n");    
        return;
    }

    public Boolean romSizeEqual(Integer value)
    {
        Boolean result = false;
        if (getRomSize() == value)
        {
            result = true;
        }
        return result;
    }
    public Integer getId() 
    {
        return id;
    }
    public Float getPrice() 
    {
        return price;
    }
    public String getProductName() 
    {
        return productName;
    }
    public Float getDisplaySizeInInches() 
    {
        return displaySizeInInches;
    }
    public Integer getRomSize() 
    {
        return romSize;
    }
    public Integer getRamSize() 
    {
        return ramSize;
    }
    public String getOsType()
    {
        return osType;
    }
    public void setPrice(Float price) 
    {
        this.price = price;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }
    public void setDisplaySizeInInches(Float displaySizeInInches)
    {
        this.displaySizeInInches = displaySizeInInches;
    }
    public void setRomSize(Integer romSize) 
    {
        this.romSize = romSize;
    }
    public void setRamSize(Integer ramSize) 
    {
        this.ramSize = ramSize;
    }
    public void setOsType(String osType) 
    {
        this.OsType = osType;
    }

}
