package com.hha.singleton.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"!InMemory","Production"})
public class MultiProfileImpl01 implements MultiProfile{
}
