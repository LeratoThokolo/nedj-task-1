package nedj.train.task1webservice.nedj.train.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Stock implements Serializable {

    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String sector;
    private String calculationPrice;
    private double open;
    private long openTime;
    private int close;
    private long closeTime;
    private double high;
    private double low;
    private double latestPrice;
    private String latestSource;
    private String latestTime;
    private String latestUpdate;
    private int latestVolume;
    private double iexRealtimePrice;
    private int iexRealtimeSize;
    private int iexLastUpdated;
    private double delayedPrice;
    private double delayedPriceTime;
    private double extendedPrice;
    private double extendedChange;
    private double extendedChangePercent;
    private double extendedPriceTime;
    private double previousClose;
    private double change;
    private double changePercent;
    private double iexMarketPercent;
    private int iexVolume;
    private int avgTotalVolume;
    private double iexBidPrice;
    private int iexBidSize;
    private double iexAskPrice;
    private int iexAskSize;
    private double marketCap;
    private double peRatio;
    private double week52High;
    private double week52Low;
    private double ytdChange;



}
