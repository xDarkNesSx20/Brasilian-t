package co.edu.unimagdalena.brasiliant.api.dto;

import java.io.Serializable;

public class CommonSummaryDTOs {
    public record UserSummary(Long id, String fullName) implements Serializable {
    }

    public record RouteSummary(Long id, String origin, String destination) implements Serializable {
    }

    public record StopSummary(Long id, String name, Integer stopOrder) implements Serializable {
    }

    public record BusSummary(Long id, String plate) implements Serializable {
    }
}
