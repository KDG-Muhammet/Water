package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.enums.Status;

import java.time.LocalDateTime;

public class OperationsDto {

    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Status status;

    private IODto ioDto;
    private BODto boDto;

    public OperationsDto(LocalDateTime arrivalTime, IODto ioDto, BODto boDto) {
        this.arrivalTime = arrivalTime;
        this.ioDto = ioDto;
        this.boDto = boDto;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public IODto getIoDto() {
        return ioDto;
    }

    public void setIoDto(IODto ioDto) {
        this.ioDto = ioDto;
    }

    public BODto getBoDto() {
        return boDto;
    }

    public void setBoDto(BODto boDto) {
        this.boDto = boDto;
    }
}
