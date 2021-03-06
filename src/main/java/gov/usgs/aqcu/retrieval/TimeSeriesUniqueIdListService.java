package gov.usgs.aqcu.retrieval;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aquaticinformatics.aquarius.sdk.timeseries.servicemodels.Publish.TimeSeriesUniqueIdListServiceRequest;
import com.aquaticinformatics.aquarius.sdk.timeseries.servicemodels.Publish.TimeSeriesUniqueIds;

import gov.usgs.aqcu.util.LogExecutionTime;

@Repository
public class TimeSeriesUniqueIdListService {
	private AquariusRetrievalService aquariusRetrievalService;

	@Autowired
	public TimeSeriesUniqueIdListService(
		AquariusRetrievalService aquariusRetrievalService
	) {
		this.aquariusRetrievalService = aquariusRetrievalService;
	}
	
	@LogExecutionTime
	public List<TimeSeriesUniqueIds> getRawResponse(String locationIdentifier) {
		TimeSeriesUniqueIdListServiceRequest request = new TimeSeriesUniqueIdListServiceRequest()
			.setLocationIdentifier(locationIdentifier);
		return aquariusRetrievalService.executePublishApiRequest(request).getTimeSeriesUniqueIds();
	}
	
	@LogExecutionTime
	public List<String> getTimeSeriesUniqueIdList(String locationIdentifier) {
		return getRawResponse(locationIdentifier).stream().map(u -> u.getUniqueId()).collect(Collectors.toList());
	}
}
