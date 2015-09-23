package com.se.datex2.common;

public enum FeedType {

	ANPR("ANPR Journey Time Data"),
    MIDAS("MIDAS Loop Traffic Data"),
    TMU("TMU Loop Traffic Data"),
    FUSED_SENSOR_ONLY("Fused Sensor-only PTD"),
    FUSED_FVD_AND_SENSOR_PTD("Fused FVD and Sensor PTD"),
    VMS("VMS and Matrix Signal Status Data"),
    NTIS_MODEL_UPDATE_NOTIFICATION("NTIS Model Update Notification"),
    EVENT("Event Data"),
	TAME("TAME Loop Traffic Data"),
	NTIS_MODEL_VMS_TABLES("NTIS Model - VMS Tables"),
	NTIS_MODEL_PREDEFINED_LOCATIONS("NTIS Model - Predefined Locations"),
	NTIS_MODEL_MEASUREMENT_SITES("NTIS Model - Measurement Sites");
	
    private String feedTypeText;

    FeedType(String feedTypeText) {
        this.feedTypeText = feedTypeText;
    }

    public String value(){
    	return feedTypeText;
    }
    
    public static FeedType getFeedType(String feedTypeText){
    	if (feedTypeText.equals(FeedType.ANPR.value())){
    		return FeedType.ANPR;
    	}else if (feedTypeText.equals(FeedType.MIDAS.value())){
    		return FeedType.MIDAS;
    	}else if (feedTypeText.equals(FeedType.TMU.value())){
    		return FeedType.TMU;
    	}else if (feedTypeText.equals(FeedType.FUSED_SENSOR_ONLY.value())){
    		return FeedType.FUSED_SENSOR_ONLY;
    	}else if (feedTypeText.equals(FeedType.FUSED_FVD_AND_SENSOR_PTD.value())){
    		return FeedType.FUSED_FVD_AND_SENSOR_PTD;
    	}else if (feedTypeText.toLowerCase().contains(FeedType.VMS.value().toLowerCase())){
    		return FeedType.VMS;
    	}else if (feedTypeText.equals(FeedType.NTIS_MODEL_UPDATE_NOTIFICATION.value())){
    		return FeedType.NTIS_MODEL_UPDATE_NOTIFICATION;
    	}else if (feedTypeText.toLowerCase().contains(FeedType.EVENT.value().toLowerCase())){
    		return FeedType.EVENT;
    	}else if (feedTypeText.equals(FeedType.TAME.value())){
    		return FeedType.TAME;
    	}else if (feedTypeText.equals(FeedType.NTIS_MODEL_VMS_TABLES.value())){
    		return FeedType.NTIS_MODEL_VMS_TABLES;
    	}else if (feedTypeText.equals(FeedType.NTIS_MODEL_PREDEFINED_LOCATIONS.value())){
    		return FeedType.NTIS_MODEL_PREDEFINED_LOCATIONS;
    	}else if (feedTypeText.equals(FeedType.NTIS_MODEL_MEASUREMENT_SITES.value())){
    		return FeedType.NTIS_MODEL_MEASUREMENT_SITES;
    	}
		return null;
    	
    }
}
