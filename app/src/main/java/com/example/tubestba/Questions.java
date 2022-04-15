package com.example.tubestba;

public class Questions {
    private String mAnswer[] = {
            "MUSTAKA",
            "RIKMA",
            "WAJA",
            "SOCA",
            "SIRAM",
            "ASMA",
            "LEPAT",
            "SARE",
            "ARTA",
            "ASTA",
            "DALU",
            "JAWAH",
            "ALIT",
            "AGENG",
            "GRANA"
    };

    private String mImages[] = {
            "mustaka",
            "rikma",
            "waja",
            "soca",
            "siram",
            "asma",
            "lepat",
            "sare",
            "arta",
            "asta",
            "dalu",
            "jawah",
            "alit",
            "ageng",
            "grana"
    };

    private int mSound[] = {
            R.raw.mustaka,
            R.raw.rikma,
            R.raw.waja,
            R.raw.soca,
            R.raw.siram,
            R.raw.asma,
            R.raw.lepat,
            R.raw.sare,
            R.raw.arta,
            R.raw.asta,
            R.raw.dalu,
            R.raw.jawah,
            R.raw.alit,
            R.raw.ageng,
            R.raw.grana
    };

    private String mPenjelasan[] = {
            "MUSTAKA = KEPALA\n\nMustaka merupakan krama inggil untuk kepala. Meski sirah sebenarnya sudah cukup halus, tapi saat bicara dengan orang yang lebih tua atau dihormati akan lebih sopan jika memakai kata ini. Namun, jangan sampai memakai kata endhas, ya. Kata ini cenderung lebih kasar dan seringkali dipakai untuk menyebut kepala hewan atau malah sebagai kata makian.",
            "RIKMA = RAMBUT\n\nBuat yang belum tahu atau lupa, rikma adalah nama lain dari rambut. Mahkota kepala ini sebenarnya punya penamaan yang sama dalam bahasa Indonesia dan bahasa Jawa. Namun, pemakaian rambut dalam bahasa Jawa tergolong dalam bahasa Jawa ngoko.",
            "WAJA = GIGI\n\nBuat yang sering memakai kata untu saat bicara dengan orang tua, yuk mulai ubah dengan kata waja. Meski sama-sama berarti gigi, tapi tingkatan kesopanannya tentu akan jauh berbeda. Kalau bicara dengan teman sebaya sih, masih gak masalah saat pakai kata untu.",
            "SOCA = MATA\n\nSoca adalah krama inggil untuk mata. Hampir sama dengan pemilihan kata untuk sirah, orang lebih sering menggunakan mripat untuk menyebut mata dalam bahasa Jawa. Gak salah sih, hanya saja peruntukkannya berbeda. Selain soca, kita juga bisa memakai istilah paningal, lho.",
            "SIRAM = MANDI\n\nSiram adalah kata dalam tingkat krama inggil yang berarti mandi. Kata ini biasa digunakan untuk berbicara dengan orang yang lebih tua atau orang yang dihormati.",
            "ASMA = NAMA\n\nAsma dalam Bahasa Jawa berarti “nama”. kata ini berada pada tingkat krama inggil.",
            "LEPAT = SALAH\n\nKata Lepat berasal dari kata Luput yang artinya meleset, keliru, atau tidak betul. Dalam Bahasa Jawa di tingkat Krama Inggil, Lepat berarti “salah” atau “keliru”.",
            "SARE = TIDUR\n\nSare merupakan kata dalam tingkat Krama Inggil/ Krama Alus, artinya tidur. Di tingkat ngoko menggunakan kata \"turu\" dan tingkat tengahnya adalah \"tilem\".",
            "ARTA = UANG\n\nDalam Bahasa Jawa tingkat Krama Inggil, “arta” berarti “uang”. Pada tingkat Bahasa Jawa Ngoko biasa menggunakan kata “duit”.",
            "ASTA = TANGAN\n\nDalam Bahasa Jawa, kata “Asta” berarti “tangan”. Hal ini berbeda arti apabila ditambahi imbuhan Ng- pada kata “Ngasta” yang memiliki arti “membawa”.",
            "DALU = MALAM\n\n“Dalu” pada Bahasa Jawa berarti “malam hari”. Kata ini biasa digunakan pada tingkat krama inggil dan krama madya atau untuk orang yang lebih tua. ",
            "JAWAH = HUJAN\n\nDalam Bahasa Jawa tingkat Krama Inggil dan krama madya, kata “jawah” berarti “hujan”. ",
            "ALIT = KECIL\n\nKata “alit” pada Bahasa Jawa tingkat Krama Inggil berarti “kecil”. Sedangkan pada tingkat ngoko biasa menggunakan kata “cilik”.",
            "AGENG = BESAR\n\n“Ageng” dalam Bahasa Jawa tingkat Krama Inggil memiliki arti “besar” atau “longgar”. ",
            "GRANA = HIDUNG\n\nKata “Grana” dalam Bahasa Jawa tingkat Krama Inggil memiliki arti “hidung”"
    };

    private String mLevel[] = {
            "Level 1",
            "Level 2",
            "Level 3",
            "Level 4",
            "Level 5",
            "Level 6",
            "Level 7",
            "Level 8",
            "Level 9",
            "Level 10",
            "Level 11",
            "Level 12",
            "Level 13",
            "Level 14",
            "Level 15"
    };

    private int mSkor[] = {
            100,
            200,
            300,
            400,
            500,
            600,
            700,
            800,
            900,
            1000,
            1100,
            1200,
            1300,
            1400,
            1500
    };

    private String mHint[] = {
            "KEPALA",
            "RAMBUT",
            "GIGI",
            "MATA",
            "MANDI",
            "NAMA",
            "SALAH",
            "TIDUR",
            "UANG",
            "TANGAN",
            "MALAM",
            "HUJAN",
            "KECIL",
            "BESAR",
            "HIDUNG"
    };

    public String getAnswer(int a) {
        String answer = mAnswer[a];
        return answer;
    }

    public String getImages(int a) {
        String img = mImages[a];
        return img;
    }

    public int getSound(int a) {
        int sound = mSound[a];
        return sound;
    }

    public String getPenjelasan(int a) {
        String penjelasan = mPenjelasan[a];
        return penjelasan;
    }

    public String getLevel(int a) {
        String level = mLevel[a];
        return level;
    }

    public int getSkor(int a) {
        int skor = mSkor[a];
        return skor;
    }

    public String getHint(int a) {
        String hint = mHint[a];
        return hint;
    }

    public int getLength() {
        return mImages.length;
    }
}
