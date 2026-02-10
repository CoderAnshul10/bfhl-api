package com.chitkara.bfhlapi.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MathService {

    // Generate Fibonacci series
    public List<Integer> generateFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Fibonacci input must be positive");
        }

        List<Integer> fibonacci = new ArrayList<>();
        if (n >= 1) fibonacci.add(0);
        if (n >= 2) fibonacci.add(1);

        for (int i = 2; i < n; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
        }

        return fibonacci;
    }

    // Filter prime numbers
    public List<Integer> filterPrimes(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Prime array cannot be empty");
        }

        List<Integer> primes = new ArrayList<>();
        for (int num : numbers) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Calculate LCM of array
    public long calculateLCM(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("LCM array cannot be empty");
        }

        long lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = lcm(lcm, numbers[i]);
        }
        return lcm;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Calculate HCF/GCD of array
    public int calculateHCF(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("HCF array cannot be empty");
        }

        int hcf = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            hcf = gcd(hcf, numbers[i]);
        }
        return hcf;
    }

    private int gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return (int) a;
    }
}