package com.java8practice.lamdaexpressions;

//Functional interface
@FunctionalInterface
interface LightAction {
 void activate();
}

public class SmartHome {
 public static void main(String[] args) {

     LightAction motionTrigger = () ->
             System.out.println("Lights ON at 70% brightness");

     LightAction nightTrigger = () ->
             System.out.println("Warm dim lights ON");

     LightAction voiceTrigger = () ->
             System.out.println("Party mode lights activated!");

     // Execute dynamically
     motionTrigger.activate();
     nightTrigger.activate();
     voiceTrigger.activate();
 }
}
