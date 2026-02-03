package com.scenariobased.collections.oceanfleat;

import java.util.LinkedList;
import java.util.List;

public class VesselUtil {
	private List<Vessel> vesselList = new LinkedList<>();

	public VesselUtil() {
	}

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}

	public void addVesselPerformance(Vessel vessel) {
		if (vessel != null) {
			vesselList.add(vessel);
			return;
		}
		return;
	}

	public Vessel getVesselById(String vesselId) {
		for (Vessel vessel : vesselList) {
			if (vessel.getVesselId().equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}

	public List<Vessel> getHighPerformanceVessels() {

		List<Vessel> result = new LinkedList<Vessel>();
		if (vesselList == null)
			return result;

		double max = Double.MIN_VALUE;
		for (Vessel vessel : vesselList) {
			max = Math.max(max, vessel.getAverageSpeed());
		}

		for (Vessel vessel : vesselList) {
			if (vessel.getAverageSpeed() == max) {
				result.add(vessel);
			}
		}

		return result;

	}
}
