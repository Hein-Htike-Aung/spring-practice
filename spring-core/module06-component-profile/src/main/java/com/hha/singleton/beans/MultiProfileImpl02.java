package com.hha.singleton.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("InMemory")
public class MultiProfileImpl02 implements MultiProfile{
}
