package in.co.mpwin.vigilencebilling.dtos;

public class LoadUnitDto {
    private String p4id;
    private String ivrs;
    private String theftType;
    private String tariff;
    private String isContinuous;
    
    private Double totalLightLoad = 0.0;
    private Double totalSeasonalLoad = 0.0;
    private Double totalPettyLoad = 0.0;

    private Double totalLightDays = 0.0;
    private Double totalSeasonalDays = 0.0;
    private Double totalPettyDays = 0.0;

    private Double totalLightMonths = 0.0;
    private Double totalSeasonalMonths = 0.0;
    private Double totalPettyMonths = 0.0;

    private Double totalLightHours = 0.0;
    private Double totalSeasonalHours = 0.0;
    private Double totalPettyHours = 0.0;

    private Double totalLightFactor = 0.0;
    private Double totalSeasonalFactor = 0.0;
    private Double totalPettyFactor = 0.0;

    private Double totalLightUnits = 0.0;
    private Double totalSeasonalUnits = 0.0;
    private Double totalPettyUnits = 0.0;

    private Double allLoadTotalUnits = 0.0;
}
