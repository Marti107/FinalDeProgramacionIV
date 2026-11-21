package model;

import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

// Implementamos Comparable para permitir el ordenamiento natural de las fechas
public class Fecha implements Comparable<Fecha> {
	
    // Constante estática para no repetir el arreglo en cada método
    private static final int[] DIAS_POR_MES = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Cambiamos "año" por "anio" para evitar errores de codificación (encoding)
    private int dia;
    private int mes;
    private int anio;
	
    public static Fecha hoy() {
        Calendar c = Calendar.getInstance();
        return new Fecha(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
    }
	
    // Lógica simplificada en una sola línea
    public static boolean bisiesto(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }
	
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 1970; // Por defecto asignamos una fecha base válida
    }
	
    public Fecha(int d, int m, int a) {
        // Fail-fast: Lanzamos la excepción que tenías anotada en los comentarios
        if (!esFechaValida(d, m, a)) {
            throw new IllegalArgumentException("Fecha incorrecta: " + d + "/" + m + "/" + a);
        }
        this.dia = d;
        this.mes = m;
        this.anio = a;
    }

    // Método auxiliar para no repetir la lógica de validación
    private static boolean esFechaValida(int d, int m, int a) {
        if (a < 1 || m < 1 || m > 12) return false;
        
        int fin = DIAS_POR_MES[m - 1];
        if (m == 2 && bisiesto(a)) {
            fin = 29;
        }
        return d >= 1 && d <= fin;
    }
	
    // Mantenemos I/O aquí según tu requerimiento, pero usamos el validador nuevo
    public static Fecha nuevaFecha() {
        Scanner entrada = new Scanner(System.in);
        int d, m, a;
        boolean valida = false;
        
        do {
            System.out.print("Ingrese Día: ");
            d = entrada.nextInt();
            System.out.print("Ingrese Mes: ");
            m = entrada.nextInt();
            System.out.print("Ingrese Año: ");
            a = entrada.nextInt();
            
            valida = esFechaValida(d, m, a);
            if (!valida) {
                System.out.println("Fecha inválida. Por favor, verifique los datos.\n");
            }
        } while (!valida);
        
        return new Fecha(d, m, a);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Fecha f = (Fecha) obj;
        return this.anio == f.anio && this.mes == f.mes && this.dia == f.dia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, anio);
    }
	
    @Override
    public int compareTo(Fecha f) {
        int f1 = this.anio * 10000 + this.mes * 100 + this.dia;
        int f2 = f.anio * 10000 + f.mes * 100 + f.dia;
        return Integer.compare(f1, f2);
    }
	
    public boolean bisiesto() {
        return Fecha.bisiesto(this.anio);
    }

    // Mantenemos tu lógica matemática intacta, pero usando el constructor directamente
    public Fecha sumarDias(int d) {
        int d2 = dia, m2 = mes, a2 = anio;
        int fin, restan;
        
        do {
            fin = DIAS_POR_MES[m2 - 1];
            if (m2 == 2 && bisiesto(a2)) fin = 29; // Fix: evaluamos a2, no el año original
            
            restan = fin - d2;
            if (restan >= d) {
                d2 += d;
                d = 0;
            } else {
                d -= restan;
                d2 = 0;
                if (m2 == 12) {
                    m2 = 1;
                    a2++;
                } else {
                    m2++;
                }
            }
        } while (d > 0);
        
        return new Fecha(d2, m2, a2);
    }
	
    public Fecha sumarMeses(int m) {
        int d2 = dia, m2 = mes, a2 = anio;
        int restan;
        do {
            restan = 12 - m2;
            if (restan >= m) {
                m2 += m;
                m = 0;
            } else {
                m -= restan;
                m2 = 0;
                a2++;
            }
        } while (m > 0);
        
        // Ajuste de seguridad: si tenías 31 de Enero y sumas 1 mes, el día debe bajar a 28 de Febrero
        int finDestino = DIAS_POR_MES[m2 - 1];
        if (m2 == 2 && bisiesto(a2)) finDestino = 29;
        if (d2 > finDestino) d2 = finDestino;
        
        return new Fecha(d2, m2, a2);
    }

    public Fecha sumarAnios(int a) {
        int d2 = dia;
        // Si es 29 de feb y el nuevo año no es bisiesto, ajustamos al 28
        if (mes == 2 && dia == 29 && !bisiesto(anio + a)) {
            d2 = 28;
        }
        return new Fecha(d2, mes, anio + a);
    }
	
    public Fecha restarDias(int d) {
        int d2 = dia, m2 = mes, a2 = anio;
        int fin;
        do {
            if (d2 > d) {
                d2 -= d;
                d = 0;
            } else {
                d -= d2;
                if (m2 == 1) {
                    fin = 31;
                    m2 = 12;
                    a2--;
                } else {
                    fin = DIAS_POR_MES[m2 - 2];
                    if ((m2 - 1) == 2 && bisiesto(a2)) fin = 29;
                    m2--;
                }
                d2 = fin;
            }
        } while (d > 0);
        
        return new Fecha(d2, m2, a2);
    }
	
    public Fecha restarMeses(int m) {
        int d2 = dia, m2 = mes, a2 = anio;
        do {
            if (m2 > m) {
                m2 -= m;
                m = 0;
            } else {
                m -= m2;
                a2--;
                m2 = 12;
            }
        } while (m > 0);
        
        int finDestino = DIAS_POR_MES[m2 - 1];
        if (m2 == 2 && bisiesto(a2)) finDestino = 29;
        if (d2 > finDestino) d2 = finDestino;
        
        return new Fecha(d2, m2, a2);
    }
	
    public Fecha restarAnios(int a) {
        int d2 = dia;
        if (mes == 2 && dia == 29 && !bisiesto(anio - a)) {
            d2 = 28;
        }
        return new Fecha(d2, mes, anio - a);
    }

    public int calcularAniosHasta(Fecha fechaDestino) {
        int edad = fechaDestino.getAnio() - this.anio;

        if (fechaDestino.getMes() < this.mes) {
            edad--;
        }
        else if (fechaDestino.getMes() == this.mes && fechaDestino.getDia() < this.dia) {
            edad--;
        }
        return edad;
    }


    public boolean entre(Fecha f1, Fecha f2) {
        return this.compareTo(f1) >= 0 && this.compareTo(f2) <= 0;
    }
	
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
    
    // Getters
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }
    
    // Los Setters se eliminan intencionalmente para mantener la "Inmutabilidad" (Buena práctica de POO).
    // Toda suma/resta devuelve un objeto nuevo sin romper la fecha original.
}