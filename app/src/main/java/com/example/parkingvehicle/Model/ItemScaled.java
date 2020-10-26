package com.example.parkingvehicle.Model;

public class ItemScaled {
    public int id = 0;
    public String bienSoXe;
    public String congVao;
    public String loaiCong;

    public ItemScaled(int id, String bienSoXe, String congVao, String loaiCong) {
        this.id = id;
        this.bienSoXe = bienSoXe;
        this.congVao = congVao;
        this.loaiCong = loaiCong;
    }

    public ItemScaled() {
        this.id = id;
        this.bienSoXe = bienSoXe;
        this.loaiCong = loaiCong;
    }

    public int getId() {
        return id;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public String getCongVao() {
        return congVao;
    }

    public String getLoaiCong() {
        return loaiCong;
    }
}
