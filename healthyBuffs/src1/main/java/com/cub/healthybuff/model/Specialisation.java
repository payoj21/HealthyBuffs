package com.cub.healthybuff.model;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialisation {
	ArrayList<Specialisation> specialisationlist;
	
}
