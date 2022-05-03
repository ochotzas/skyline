package src;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Αποδοτικός Αλγόριθμος για ερωτήματα
 * κορυφογραμμής (Skyline queries).
 * <p>
 * Ένας προσαρμοσμένος αλγόριθμος που
 * χρησιμοποιείται για την επίλυση
 * ερωτημάτων κορυφογραμμής.
 *
 * @author Ολγκέρ Χότζα
 * @version 1.0
 * @email ochotzas@csd.auth.gr
 */

class Skyline
{
    /**
     * Μέθοδος υπολογισμού ελάχιστων σημείων βάση της
     * τεταγμένης τους σε σχέση με την τετμημένη τους.
     * <p>
     * Σχέση: x1<=x2 και y1<=y2 και (x1!=x2 ή y1!=y2)
     *
     * @param buildings Πίνακας με σημεία.
     * @return Λίστα με τα αποτελέσματα κορυφογραμμής.
     */
    public ArrayList<Point> getSkyline(Point[] buildings)
    {
        ArrayList<Point> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return result;

        buildings = sortByX(buildings);

        int k = 0;
        for (int i = 0; i < buildings.length; i++)
        {
            if (result.isEmpty())
            {
                if (buildings[i].x <= buildings[i + 1].x)
                    result.add(new Point(buildings[i].x, buildings[i].y));
            } else if (buildings[i].x >= result.get(k).x && buildings[i].y < result.get(k).y && (buildings[i].x != result.get(k).x || buildings[i].y != result.get(k).y))
            {
                result.add(new Point(buildings[i].x, buildings[i].y));
                k++;
            }
        }

        return result;
    }

    /**
     * Ταξινόμησή του πίνακα βάση της τετμημένης των σημείων
     * αναδρομικά με βάση τον αλγόριθμο merge sort.
     *
     * @param buildings Ο πίνακας με τα σημεία.
     * @return Τον ταξινομημένο πίνακα.
     */
    private Point[] sortByX(Point[] buildings)
    {
        if (buildings.length <= 1)
            return buildings;

        int mid = buildings.length / 2;
        Point[] left = new Point[mid];
        Point[] right = new Point[buildings.length - mid];

        System.arraycopy(buildings, 0, left, 0, mid);
        System.arraycopy(buildings, mid, right, 0, buildings.length - mid);

        left = sortByX(left);
        right = sortByX(right);

        return merge(left, right);
    }

    /**
     * Συγχωνεύει τα δυο μέρη του πίνακα σε ένα πίνακα
     * με βάση την τετμημένη και την τεταγμένη τους.
     * <p>
     * Ταξινομούμε τον πίνακα κατά αύξουσα σειρά βάση
     * της τετμημένης των σημείων. Σε περίπτωση που η
     * τετμημένη του σημείου είναι ίση με την τετμημένη
     * του άλλου σημείου, τότε ταξινομούμε τα σημεία βάση
     * της τεταγμένης του σημείου.
     *
     * @param left  Ο πίνακας με τα δεξιά στοιχεία.
     * @param right Ο πίνακας με τα αριστερά στοιχεία.
     * @return Τον συγχωνευμένο πίνακα.
     */
    private Point[] merge(Point[] left, Point[] right)
    {
        int i = 0, j = 0, k = 0;
        Point[] result = new Point[left.length + right.length];

        while (i < left.length && j < right.length)
        {
            if (left[i].x < right[j].x)
                result[k++] = left[i++];
            else if (left[i].x == right[j].x)
            {
                if (left[i].y < right[j].y)
                    result[k++] = left[i++];
                else
                    result[k++] = right[j++];
            } else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

        return result;
    }

    /**
     * Βασική συνάρτηση για την εκτέλεση του προγράμματος.
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new FileReader(args[0]));
        int size = Integer.parseInt(bf.readLine());
        Point[] all = new Point[size];

        int i = 0;
        for (String line; (line = bf.readLine()) != null; )
        {
            String[] lineSep = line.split(" ");
            all[i++] = new Point(Integer.parseInt(lineSep[0]), Integer.parseInt(lineSep[1]));
        }

        ArrayList<Point> result = new Skyline().getSkyline(all);

        for (Point p : result)
            System.out.println(p.x + " " + p.y);
    }
}